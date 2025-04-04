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

package im.heart.continew.member.service;

import im.heart.continew.member.model.entity.MemberSocialDO;
import me.zhyd.oauth.model.AuthUser;

import java.util.List;

/**
 * 用户社会化关联业务接口
 *
 * @author Charles7c
 * @since 2023/10/11 22:10
 */
public interface MemberSocialService {

    /**
     * 根据来源和开放 ID 查询
     *
     * @param source 来源
     * @param openId 开放 ID
     * @return 用户社会化关联信息
     */
    MemberSocialDO getBySourceAndOpenId(String source, String openId);

    /**
     * 保存
     *
     * @param memberSocial 用户社会化关联信息
     */
    void saveOrUpdate(MemberSocialDO memberSocial);

    /**
     * 根据用户 ID 查询
     *
     * @param memberId 用户 ID
     * @return 用户社会化关联信息
     */
    List<MemberSocialDO> listByMemberId(Long memberId);

    /**
     * 绑定
     *
     * @param authUser 三方账号信息
     * @param memberId 用户 ID
     */
    void bind(AuthUser authUser, Long memberId);

    /**
     * 根据来源和用户 ID 删除
     *
     * @param source   来源
     * @param memberId 用户 ID
     */
    void deleteBySourceAndMemberId(String source, Long memberId);

    /**
     * 根据用户 ID 删除
     *
     * @param memberIds 用户 ID 列表
     */
    void deleteByMemberIds(List<Long> memberIds);
}