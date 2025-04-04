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

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONUtil;
import im.heart.continew.member.mapper.MemberSocialMapper;
import im.heart.continew.member.model.entity.MemberSocialDO;
import im.heart.continew.member.service.MemberSocialService;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.model.AuthUser;
import org.springframework.stereotype.Service;
import top.continew.admin.system.enums.SocialSourceEnum;
import top.continew.starter.core.validation.CheckUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 用户社会化关联业务实现
 *
 * @author Charles7c
 * @since 2023/10/11 22:10
 */
@Service
@RequiredArgsConstructor
public class MemberSocialServiceImpl implements MemberSocialService {

    private final MemberSocialMapper baseMapper;

    @Override
    public MemberSocialDO getBySourceAndOpenId(String source, String openId) {
        return baseMapper.selectBySourceAndOpenId(source, openId);
    }

    @Override
    public void saveOrUpdate(MemberSocialDO memberSocial) {
        if (null == memberSocial.getCreateTime()) {
            baseMapper.insert(memberSocial);
        } else {
            baseMapper.lambdaUpdate()
                .set(MemberSocialDO::getMetaJson, memberSocial.getMetaJson())
                .set(MemberSocialDO::getLastLoginTime, memberSocial.getLastLoginTime())
                .eq(MemberSocialDO::getSource, memberSocial.getSource())
                .eq(MemberSocialDO::getOpenId, memberSocial.getOpenId())
                .update();
        }
    }

    @Override
    public List<MemberSocialDO> listByMemberId(Long memberId) {
        return baseMapper.lambdaQuery().eq(MemberSocialDO::getUserId, memberId).list();
    }

    @Override
    public void bind(AuthUser authUser, Long memberId) {
        String source = authUser.getSource();
        String openId = authUser.getUuid();
        List<MemberSocialDO> userSocialList = this.listByMemberId(memberId);
        Set<String> boundSocialSet = userSocialList.stream().map(MemberSocialDO::getSource).collect(Collectors.toSet());
        String description = SocialSourceEnum.valueOf(source).getDescription();
        CheckUtils.throwIf(boundSocialSet.contains(source), "您已经绑定过了 [{}] 平台，请先解绑", description);
        MemberSocialDO memberSocial = this.getBySourceAndOpenId(source, openId);
        CheckUtils.throwIfNotNull(memberSocial, "[{}] 平台账号 [{}] 已被其他用户绑定", description, authUser.getUsername());
        memberSocial = new MemberSocialDO();
        memberSocial.setUserId(memberId);
        memberSocial.setSource(source);
        memberSocial.setOpenId(openId);
        memberSocial.setMetaJson(JSONUtil.toJsonStr(authUser));
        memberSocial.setLastLoginTime(LocalDateTime.now());
        baseMapper.insert(memberSocial);
    }

    @Override
    public void deleteBySourceAndMemberId(String source, Long memberId) {
        baseMapper.lambdaUpdate()
            .eq(MemberSocialDO::getSource, source)
            .eq(MemberSocialDO::getUserId, memberId)
            .remove();
    }

    @Override
    public void deleteByMemberIds(List<Long> userIds) {
        if (CollUtil.isEmpty(userIds)) {
            return;
        }
        baseMapper.lambdaUpdate().in(MemberSocialDO::getUserId, userIds).remove();
    }
}
