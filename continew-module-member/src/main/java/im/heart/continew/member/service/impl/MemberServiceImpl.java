/*
 * Copyright (c) 2022-present Charles7c Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.heart.continew.member.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import im.heart.continew.member.auth.service.OnlineMemberService;
import im.heart.continew.member.context.MemberContext;
import im.heart.continew.member.context.MemberContextHolder;
import im.heart.continew.member.mapper.MemberMapper;
import im.heart.continew.member.model.entity.MemberDO;
import im.heart.continew.member.model.query.MemberQuery;
import im.heart.continew.member.model.req.MemberBasicInfoUpdateReq;
import im.heart.continew.member.model.req.MemberPasswordResetReq;
import im.heart.continew.member.model.req.MemberReq;
import im.heart.continew.member.model.resp.MemberDetailResp;
import im.heart.continew.member.model.resp.MemberResp;
import im.heart.continew.member.service.MemberPasswordHistoryService;
import im.heart.continew.member.service.MemberService;
import im.heart.continew.member.service.MemberSocialService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dromara.x.file.storage.core.FileInfo;
import org.dromara.x.file.storage.core.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.system.enums.OptionCategoryEnum;
import top.continew.admin.system.service.DeptService;
import top.continew.admin.system.service.FileService;
import top.continew.admin.system.service.OptionService;
import top.continew.core.validator.ValidatorUtils;
import top.continew.starter.core.constant.StringConstants;
import top.continew.starter.core.validation.CheckUtils;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.query.SortQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;
import top.continew.starter.extension.crud.service.BaseServiceImpl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static im.heart.continew.member.auth.enums.MemberPasswordPolicyEnum.*;

/**
 * 用户业务实现
 *
 * @author Charles7c
 * @since 2022/12/21 21:49
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl extends BaseServiceImpl<MemberMapper, MemberDO, MemberResp, MemberDetailResp, MemberQuery, MemberReq> implements MemberService {

    private final PasswordEncoder passwordEncoder;
    private final MemberPasswordHistoryService memberPasswordHistoryService;
    private final MemberSocialService memberSocialService;
    private final OptionService optionService;
    private final OnlineMemberService onlineMemberService;
    private final FileService fileService;
    private final FileStorageService fileStorageService;

    @Resource
    private DeptService deptService;
    @Value("${avatar.support-suffix}")
    private String[] avatarSupportSuffix;
    @Value("${avatar.path}")
    private String avatarPath;

    @Override
    public PageResp<MemberResp> page(MemberQuery query, PageQuery pageQuery) {
        QueryWrapper<MemberDO> queryWrapper = this.buildQueryWrapper(query);
        super.sort(queryWrapper, pageQuery);
        IPage<MemberDetailResp> page = baseMapper.selectUserPage(new Page<>(pageQuery.getPage(), pageQuery
            .getSize()), queryWrapper);
        PageResp<MemberResp> pageResp = PageResp.build(page, super.getListClass());
        pageResp.getList().forEach(this::fill);
        return pageResp;
    }

    @Override
    public void beforeCreate(MemberReq req) {
        final String errorMsgTemplate = "新增失败，[{}] 已存在";
        String username = req.getUsername();
        CheckUtils.throwIf(this.isNameExists(username, null), errorMsgTemplate, username);
        String email = req.getEmail();
        CheckUtils.throwIf(StrUtil.isNotBlank(email) && this.isEmailExists(email, null), errorMsgTemplate, email);
        String phone = req.getPhone();
        CheckUtils.throwIf(StrUtil.isNotBlank(phone) && this.isPhoneExists(phone, null), errorMsgTemplate, phone);
    }

    @Override
    public void afterCreate(MemberReq req, MemberDO user) {
        Long userId = user.getId();
        baseMapper.lambdaUpdate()
            .set(MemberDO::getPwdResetTime, LocalDateTime.now())
            .eq(MemberDO::getId, userId)
            .update();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheUpdate(key = "#id", value = "#req.nickname", name = CacheConstants.USER_KEY_PREFIX)
    public void update(MemberReq req, Long id) {
        final String errorMsgTemplate = "修改失败，[{}] 已存在";
        String username = req.getUsername();
        CheckUtils.throwIf(this.isNameExists(username, id), errorMsgTemplate, username);
        String email = req.getEmail();
        CheckUtils.throwIf(StrUtil.isNotBlank(email) && this.isEmailExists(email, id), errorMsgTemplate, email);
        String phone = req.getPhone();
        CheckUtils.throwIf(StrUtil.isNotBlank(phone) && this.isPhoneExists(phone, id), errorMsgTemplate, phone);
        DisEnableStatusEnum newStatus = req.getStatus();
        CheckUtils.throwIf(DisEnableStatusEnum.DISABLE.equals(newStatus) && ObjectUtil.equal(id, MemberContextHolder
            .getUserId()), "不允许禁用当前用户");
        MemberDO oldMember = super.getById(id);
        // 更新信息
        MemberDO newMember = BeanUtil.toBean(req, MemberDO.class);
        newMember.setId(id);
        baseMapper.updateById(newMember);
        // 保存用户和角色关联
        // 如果禁用用户，则踢出在线用户
        if (DisEnableStatusEnum.DISABLE.equals(newStatus)) {
            onlineMemberService.kickOut(id);
            return;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheInvalidate(key = "#ids", name = CacheConstants.USER_KEY_PREFIX, multi = true)
    public void delete(List<Long> ids) {
        CheckUtils.throwIf(CollUtil.contains(ids, MemberContextHolder.getUserId()), "不允许删除当前用户");
        List<MemberDO> list = baseMapper.lambdaQuery()
            .select(MemberDO::getNickname, MemberDO::getIsSystem)
            .in(MemberDO::getId, ids)
            .list();
        Optional<MemberDO> isSystemData = list.stream().filter(MemberDO::getIsSystem).findFirst();
        CheckUtils.throwIf(isSystemData::isPresent, "所选用户 [{}] 是系统内置用户，不允许删除", isSystemData.orElseGet(MemberDO::new)
            .getNickname());
        // 删除用户和角色关联
        // 删除历史密码
        memberPasswordHistoryService.deleteByUserIds(ids);
        // 删除用户绑定的第三方账号信息
        memberSocialService.deleteByMemberIds(ids);
        // 删除用户
        super.delete(ids);
        // 踢出在线用户
        ids.forEach(onlineMemberService::kickOut);
    }

    @Override
    public void resetPassword(MemberPasswordResetReq req, Long id) {
        super.getById(id);
        baseMapper.lambdaUpdate()
            .set(MemberDO::getPassword, req.getNewPassword())
            .set(MemberDO::getPwdResetTime, LocalDateTime.now())
            .eq(MemberDO::getId, id)
            .update();
    }

    @Override
    public String updateAvatar(MultipartFile avatarFile, Long id) throws IOException {
        String avatarImageType = FileNameUtil.extName(avatarFile.getOriginalFilename());
        CheckUtils.throwIf(!StrUtil.equalsAnyIgnoreCase(avatarImageType, avatarSupportSuffix), "头像仅支持 {} 格式的图片", String
            .join(StringConstants.CHINESE_COMMA, avatarSupportSuffix));
        // 上传新头像
        MemberDO user = super.getById(id);
        FileInfo fileInfo = fileService.upload(avatarFile, avatarPath);
        // 更新用户头像
        String newAvatar = fileInfo.getUrl();
        baseMapper.lambdaUpdate().set(MemberDO::getAvatar, newAvatar).eq(MemberDO::getId, id).update();
        // 删除原头像
        String oldAvatar = user.getAvatar();
        if (StrUtil.isNotBlank(oldAvatar)) {
            fileStorageService.delete(oldAvatar);
        }
        return newAvatar;
    }

    @Override
    @CacheUpdate(key = "#id", value = "#req.nickname", name = CacheConstants.USER_KEY_PREFIX)
    public void updateBasicInfo(MemberBasicInfoUpdateReq req, Long id) {
        super.getById(id);
        baseMapper.lambdaUpdate()
            .set(MemberDO::getNickname, req.getNickname())
            .set(MemberDO::getGender, req.getGender())
            .eq(MemberDO::getId, id)
            .update();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(String oldPassword, String newPassword, Long id) {
        CheckUtils.throwIfEqual(newPassword, oldPassword, "新密码不能与当前密码相同");
        MemberDO user = super.getById(id);
        String password = user.getPassword();
        if (StrUtil.isNotBlank(password)) {
            CheckUtils.throwIf(!passwordEncoder.matches(oldPassword, password), "当前密码不正确");
        }
        // 校验密码合法性
        int passwordRepetitionTimes = this.checkPassword(newPassword, user);
        // 更新密码和密码重置时间
        baseMapper.lambdaUpdate()
            .set(MemberDO::getPassword, newPassword)
            .set(MemberDO::getPwdResetTime, LocalDateTime.now())
            .eq(MemberDO::getId, id)
            .update();
        // 保存历史密码
        memberPasswordHistoryService.add(id, password, passwordRepetitionTimes);
        // 修改后登出
        StpUtil.logout();
    }

    @Override
    public void updatePhone(String newPhone, String oldPassword, Long id) {
        MemberDO user = super.getById(id);
        CheckUtils.throwIf(!passwordEncoder.matches(oldPassword, user.getPassword()), "当前密码不正确");
        CheckUtils.throwIf(this.isPhoneExists(newPhone, id), "手机号已绑定其他账号，请更换其他手机号");
        CheckUtils.throwIfEqual(newPhone, user.getPhone(), "新手机号不能与当前手机号相同");
        // 更新手机号
        baseMapper.lambdaUpdate().set(MemberDO::getPhone, newPhone).eq(MemberDO::getId, id).update();
    }

    @Override
    public void updateEmail(String newEmail, String oldPassword, Long id) {
        MemberDO user = super.getById(id);
        CheckUtils.throwIf(!passwordEncoder.matches(oldPassword, user.getPassword()), "当前密码不正确");
        CheckUtils.throwIf(this.isEmailExists(newEmail, id), "邮箱已绑定其他账号，请更换其他邮箱");
        CheckUtils.throwIfEqual(newEmail, user.getEmail(), "新邮箱不能与当前邮箱相同");
        // 更新邮箱
        baseMapper.lambdaUpdate().set(MemberDO::getEmail, newEmail).eq(MemberDO::getId, id).update();
    }

    @Override
    public MemberDO getByUsername(String username) {
        return baseMapper.selectByUsername(username);
    }

    @Override
    public MemberDO getByAccount(String account) {
        if (ValidatorUtils.isEmail(account)) {
            return baseMapper.selectByEmail(account);
        }
        if (ValidatorUtils.isPhone(account)) {
            return baseMapper.selectByPhone(account);
        }
        return baseMapper.selectByUsername(account);
    }

    @Override
    public MemberDO getByPhone(String phone) {
        return baseMapper.selectByPhone(phone);
    }

    @Override
    public MemberDO getByEmail(String email) {
        return baseMapper.selectByEmail(email);
    }

    @Override
    protected <E> List<E> list(MemberQuery query, SortQuery sortQuery, Class<E> targetClass) {
        QueryWrapper<MemberDO> queryWrapper = this.buildQueryWrapper(query);
        // 设置排序
        super.sort(queryWrapper, sortQuery);
        List<MemberDetailResp> entityList = baseMapper.selectUserList(queryWrapper);
        if (this.getEntityClass() == targetClass) {
            return (List<E>)entityList;
        }
        return BeanUtil.copyToList(entityList, targetClass);
    }

    @Override
    protected QueryWrapper<MemberDO> buildQueryWrapper(MemberQuery query) {
        String description = query.getDescription();
        DisEnableStatusEnum status = query.getStatus();
        List<LocalDateTime> createTimeList = query.getCreateTime();
        List<Long> userIdList = query.getUserIds();
        // 获取排除用户 ID 列表
        return new QueryWrapper<MemberDO>().and(StrUtil.isNotBlank(description), q -> q.like("t1.username", description)
            .or()
            .like("t1.nickname", description)
            .or()
            .like("t1.description", description))
            .eq(null != status, "t1.status", status)
            .between(CollUtil.isNotEmpty(createTimeList), "t1.create_time", CollUtil.getFirst(createTimeList), CollUtil
                .getLast(createTimeList))
            .in(CollUtil.isNotEmpty(userIdList), "t1.id", userIdList);
    }

    /**
     * 检测密码合法性
     *
     * @param password 密码
     * @param user     用户信息
     * @return 密码允许重复使用次数
     */
    private int checkPassword(String password, MemberDO user) {
        Map<String, String> passwordPolicy = optionService.getByCategory(OptionCategoryEnum.PASSWORD);
        // 密码最小长度
        PASSWORD_MIN_LENGTH.validate(password, MapUtil.getInt(passwordPolicy, PASSWORD_MIN_LENGTH.name()), user);
        // 密码是否必须包含特殊字符
        PASSWORD_REQUIRE_SYMBOLS.validate(password, MapUtil.getInt(passwordPolicy, PASSWORD_REQUIRE_SYMBOLS
            .name()), user);
        // 密码是否允许包含正反序账号名
        PASSWORD_ALLOW_CONTAIN_USERNAME.validate(password, MapUtil
            .getInt(passwordPolicy, PASSWORD_ALLOW_CONTAIN_USERNAME.name()), user);
        // 密码重复使用次数
        int passwordRepetitionTimes = MapUtil.getInt(passwordPolicy, PASSWORD_REPETITION_TIMES.name());
        PASSWORD_REPETITION_TIMES.validate(password, passwordRepetitionTimes, user);
        return passwordRepetitionTimes;
    }

    /**
     * 名称是否存在
     *
     * @param name 名称
     * @param id   ID
     * @return 是否存在
     */
    private boolean isNameExists(String name, Long id) {
        return baseMapper.lambdaQuery().eq(MemberDO::getUsername, name).ne(null != id, MemberDO::getId, id).exists();
    }

    /**
     * 邮箱是否存在
     *
     * @param email 邮箱
     * @param id    ID
     * @return 是否存在
     */
    private boolean isEmailExists(String email, Long id) {
        Long count = baseMapper.selectCountByEmail(email, id);
        return null != count && count > 0;
    }

    /**
     * 手机号码是否存在
     *
     * @param phone 手机号码
     * @param id    ID
     * @return 是否存在
     */
    private boolean isPhoneExists(String phone, Long id) {
        Long count = baseMapper.selectCountByPhone(phone, id);
        return null != count && count > 0;
    }

    /**
     * 根据用户名获取用户列表
     *
     * @param usernames 用户名列表
     * @return 用户列表
     */
    private List<MemberDO> listByUsernames(List<String> usernames) {
        return this.list(Wrappers.<MemberDO>lambdaQuery()
            .in(MemberDO::getUsername, usernames)
            .select(MemberDO::getId, MemberDO::getUsername));
    }

    /**
     * 更新用户上下文信息
     *
     * @param id ID
     */
    private void updateContext(Long id) {
        MemberContext userContext = MemberContextHolder.getContext(id);
        if (null != userContext) {
            MemberContextHolder.setContext(userContext);
        }
    }
}
