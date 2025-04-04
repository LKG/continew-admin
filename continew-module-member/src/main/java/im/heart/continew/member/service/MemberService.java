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

import im.heart.continew.member.model.entity.MemberDO;
import im.heart.continew.member.model.query.MemberQuery;
import im.heart.continew.member.model.req.MemberBasicInfoUpdateReq;
import im.heart.continew.member.model.req.MemberPasswordResetReq;
import im.heart.continew.member.model.req.MemberReq;
import im.heart.continew.member.model.resp.MemberDetailResp;
import im.heart.continew.member.model.resp.MemberResp;
import org.springframework.web.multipart.MultipartFile;
import top.continew.admin.system.model.req.user.*;
import top.continew.starter.data.mp.service.IService;
import top.continew.starter.extension.crud.service.BaseService;

import java.io.IOException;

/**
 * 用户业务接口
 *
 * @author Charles7c
 * @since 2022/12/21 21:48
 */
public interface MemberService extends BaseService<MemberResp, MemberDetailResp, MemberQuery, MemberReq>, IService<MemberDO> {

    /**
     * 重置密码
     *
     * @param req 重置信息
     * @param id  ID
     */
    void resetPassword(MemberPasswordResetReq req, Long id);

    /**
     * 上传头像
     *
     * @param avatar 头像文件
     * @param id     ID
     * @return 新头像路径
     * @throws IOException /
     */
    String updateAvatar(MultipartFile avatar, Long id) throws IOException;

    /**
     * 修改基础信息
     *
     * @param req 修改信息
     * @param id  ID
     */
    void updateBasicInfo(MemberBasicInfoUpdateReq req, Long id);

    /**
     * 修改密码
     *
     * @param oldPassword 当前密码
     * @param newPassword 新密码
     * @param id          ID
     */
    void updatePassword(String oldPassword, String newPassword, Long id);

    /**
     * 修改手机号
     *
     * @param newPhone    新手机号
     * @param oldPassword 当前密码
     * @param id          ID
     */
    void updatePhone(String newPhone, String oldPassword, Long id);

    /**
     * 修改邮箱
     *
     * @param newEmail    新邮箱
     * @param oldPassword 当前密码
     * @param id          ID
     */
    void updateEmail(String newEmail, String oldPassword, Long id);

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return 用户信息
     */
    MemberDO getByUsername(String username);

    /**
     * 根据用户名查询
     *
     * @param account 用户名/手机号/邮箱
     * @return 用户信息
     */
    MemberDO getByAccount(String account);

    /**
     * 根据手机号查询
     *
     * @param phone 手机号
     * @return 用户信息
     */
    MemberDO getByPhone(String phone);

    /**
     * 根据邮箱查询
     *
     * @param email 邮箱
     * @return 用户信息
     */
    MemberDO getByEmail(String email);

}
