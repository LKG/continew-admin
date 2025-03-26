/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package top.continew.admin.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.system.mapper.DictItemMapper;
import top.continew.admin.system.model.entity.DeptDO;
import top.continew.admin.system.model.entity.DictItemDO;
import top.continew.admin.system.model.query.DictItemQuery;
import top.continew.admin.system.model.req.DictItemReq;
import top.continew.admin.system.model.resp.DictItemResp;
import top.continew.admin.system.service.DictItemService;
import top.continew.starter.cache.redisson.util.RedisUtils;
import top.continew.starter.core.autoconfigure.project.ProjectProperties;
import top.continew.starter.core.constant.StringConstants;
import top.continew.starter.core.enums.BaseEnum;
import top.continew.starter.core.validation.CheckUtils;
import top.continew.starter.data.core.enums.DatabaseType;
import top.continew.starter.data.core.util.MetaUtils;
import top.continew.starter.extension.crud.model.resp.LabelValueResp;
import top.continew.starter.extension.crud.service.BaseServiceImpl;

import javax.sql.DataSource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 字典项业务实现
 *
 * @author Charles7c
 * @since 2023/9/11 21:29
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DictItemServiceImpl extends BaseServiceImpl<DictItemMapper, DictItemDO, DictItemResp, DictItemResp, DictItemQuery, DictItemReq> implements DictItemService {

    private final ProjectProperties projectProperties;
    private static final Map<String, List<LabelValueResp>> ENUM_DICT_CACHE = new ConcurrentHashMap<>();
    @Resource
    private DataSource dataSource;
    @Override
    public void beforeAdd(DictItemReq req) {
        String value = req.getValue();
        CheckUtils.throwIf(this.isValueExists(value, null, req.getDictId()), "新增失败，字典值 [{}] 已存在", value);
        RedisUtils.deleteByPattern(CacheConstants.DICT_KEY_PREFIX + StringConstants.ASTERISK);
        if (ObjectUtil.isNull(req.getParentId())) {
            req.setParentId(0L);
        }
        if(req.getParentId()!=0L){
            req.setAncestors(this.getAncestors(req.getParentId()));
            Optional.ofNullable(req.getAncestors())
                    .map(ancestors -> StrUtil.split(ancestors, StringConstants.COMMA))
                    .ifPresent(list -> req.setItemLevel(list.size()));
        }
    }
    /**
     * 获取祖级列表
     *
     * @param parentId 上级部门
     * @return 祖级列表
     */
    private String getAncestors(Long parentId) {
        DictItemDO parent = this.getByParentId(parentId);
        return "%s,%s".formatted(parent.getAncestors(), parentId);
    }
    /**
     * 根据节点部门 ID 查询
     *
     * @param parentId 上级节点 ID
     * @return 上级节点信息
     */
    private DictItemDO getByParentId(Long parentId) {
        DictItemDO parent = baseMapper.selectById(parentId);
        CheckUtils.throwIfNull(parent, "上级节点不存在");
        return parent;
    }
    @Override
    public void beforeUpdate(DictItemReq req, Long id) {
        String value = req.getValue();
        CheckUtils.throwIf(this.isValueExists(value, id, req.getDictId()), "修改失败，字典值 [{}] 已存在", value);
        DictItemDO old = super.getById(id);
        String oldName = old.getLabel();
        DisEnableStatusEnum newStatus = req.getStatus();
        Long oldParentId = old.getParentId();
        // 启用/禁用部门
        if (ObjectUtil.notEqual(newStatus, old.getStatus())) {
            List<DictItemDO> children = this.listChildren(id);
            long enabledChildrenCount = children.stream()
                    .filter(d -> DisEnableStatusEnum.ENABLE.equals(d.getStatus()))
                    .count();
            CheckUtils.throwIf(DisEnableStatusEnum.DISABLE
                    .equals(newStatus) && enabledChildrenCount > 0, "禁用 [{}] 前，请先禁用其所有下级节点", oldName);
            DictItemDO oldParentDept = this.getByParentId(oldParentId);
            CheckUtils.throwIf(DisEnableStatusEnum.ENABLE.equals(newStatus) && DisEnableStatusEnum.DISABLE
                    .equals(oldParentDept.getStatus()), "启用 [{}] 前，请先启用其所有上级部门", oldName);
        }
        // 变更上级
        if (ObjectUtil.notEqual(req.getParentId(), oldParentId)) {
            // 更新祖级列表
            String newAncestors = this.getAncestors(req.getParentId());
            req.setAncestors(newAncestors);
            // 更新子级的祖级列表
            this.updateChildrenAncestors(newAncestors, old.getAncestors(), id);
        }
        if(req.getParentId()!=0L){
            req.setAncestors(this.getAncestors(req.getParentId()));
            Optional.ofNullable(req.getAncestors())
                    .map(ancestors -> StrUtil.split(ancestors, StringConstants.COMMA))
                    .ifPresent(list -> req.setItemLevel(list.size()));
        }
        RedisUtils.deleteByPattern(CacheConstants.DICT_KEY_PREFIX + StringConstants.ASTERISK);
    }
    /**
     * 更新子级祖级列表
     *
     * @param newAncestors 新祖级列表
     * @param oldAncestors 原祖级列表
     * @param id           ID
     */
    private void updateChildrenAncestors(String newAncestors, String oldAncestors, Long id) {
        List<DictItemDO> children = this.listChildren(id);
        if (CollUtil.isEmpty(children)) {
            return;
        }
        List<DictItemDO> list = new ArrayList<>(children.size());
        for (DictItemDO child : children) {
            DictItemDO item = new DictItemDO();
            item.setId(child.getId());
            item.setAncestors(child.getAncestors().replaceFirst(oldAncestors, newAncestors));
            Optional.ofNullable(item.getAncestors())
                    .map(ancestors -> StrUtil.split(ancestors, StringConstants.COMMA))
                    .ifPresent(is -> item.setItemLevel(is.size()));
            list.add(item);
        }
        baseMapper.updateById(list);
    }
    @Override
    public List<LabelValueResp> listByDictCode(String dictCode) {
        return Optional.ofNullable(ENUM_DICT_CACHE.get(dictCode.toLowerCase()))
            .orElseGet(() -> baseMapper.listByDictCode(dictCode));
    }
    @Override
    public List<DictItemDO> listChildren(Long id) {
        DatabaseType databaseType = MetaUtils.getDatabaseTypeOrDefault(dataSource, DatabaseType.MYSQL);
        return baseMapper.lambdaQuery().apply(databaseType.findInSet(id, "ancestors")).list();
    }
    @Override
    public void deleteByDictIds(List<Long> dictIds) {
        if (CollUtil.isEmpty(dictIds)) {
            return;
        }
        baseMapper.lambdaUpdate().in(DictItemDO::getDictId, dictIds).remove();
        RedisUtils.deleteByPattern(CacheConstants.DICT_KEY_PREFIX + StringConstants.ASTERISK);
    }

    @Override
    public List<String> listEnumDictNames() {
        return ENUM_DICT_CACHE.keySet().stream().toList();
    }

    /**
     * 字典值是否存在
     *
     * @param value  字典值
     * @param id     ID
     * @param dictId 字典 ID
     * @return 是否存在
     */
    private boolean isValueExists(String value, Long id, Long dictId) {
        return baseMapper.lambdaQuery()
            .eq(DictItemDO::getValue, value)
            .eq(DictItemDO::getDictId, dictId)
            .ne(null != id, DictItemDO::getId, id)
            .exists();
    }

    /**
     * 将枚举转换为枚举字典
     *
     * @param enumClass 枚举类型
     * @return 枚举字典
     */
    private List<LabelValueResp> toEnumDict(Class<?> enumClass) {
        Object[] enumConstants = enumClass.getEnumConstants();
        if (ArrayUtil.isEmpty(enumConstants)) {
            return List.of();
        }
        return Arrays.stream(enumConstants).map(e -> {
            BaseEnum baseEnum = (BaseEnum)e;
            return new LabelValueResp(baseEnum.getDescription(), baseEnum.getValue(), baseEnum.getColor());
        }).toList();
    }

    /**
     * 缓存枚举字典
     */
    @PostConstruct
    public void init() {
        Set<Class<?>> classSet = ClassUtil.scanPackageBySuper(projectProperties.getBasePackage(), BaseEnum.class);
        for (Class<?> cls : classSet) {
            List<LabelValueResp> value = this.toEnumDict(cls);
            if (CollUtil.isEmpty(value)) {
                continue;
            }
            String key = StrUtil.toUnderlineCase(cls.getSimpleName()).toLowerCase();
            ENUM_DICT_CACHE.put(key, value);
        }
        log.debug("枚举字典已缓存到内存：{}", ENUM_DICT_CACHE.keySet());
    }
}