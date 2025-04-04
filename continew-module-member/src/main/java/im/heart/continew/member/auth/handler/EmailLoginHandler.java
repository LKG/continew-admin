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

package im.heart.continew.member.auth.handler;

import im.heart.continew.member.auth.AbstractMemberLoginHandler;
import im.heart.continew.member.auth.enums.AuthTypeEnum;
import im.heart.continew.member.auth.model.req.EmailLoginReq;
import im.heart.continew.member.auth.model.resp.MemberLoginResp;
import im.heart.continew.member.model.entity.MemberDO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.system.model.resp.ClientResp;
import top.continew.starter.cache.redisson.util.RedisUtils;
import top.continew.starter.core.validation.ValidationUtils;

/**
 * 邮箱登录处理器
 *
 * @author KAI
 * @author Charles7c
 * @since 2024/12/22 14:58
 */
@Component
public class EmailLoginHandler extends AbstractMemberLoginHandler<EmailLoginReq> {

    @Override
    public MemberLoginResp login(EmailLoginReq req, ClientResp client, HttpServletRequest request) {
        // 验证邮箱
        MemberDO member = memberService.getByEmail(req.getEmail());
        ValidationUtils.throwIfNull(member, "此邮箱未绑定本系统账号");
        // 检查用户状态
        super.checkUserStatus(member);
        // 执行认证
        String token = super.authenticate(member, client);
        return MemberLoginResp.builder().token(token).build();
    }

    @Override
    public void preLogin(EmailLoginReq req, ClientResp client, HttpServletRequest request) {
        String email = req.getEmail();
        String captchaKey = CacheConstants.CAPTCHA_KEY_PREFIX + email;
        String captcha = RedisUtils.get(captchaKey);
        ValidationUtils.throwIfBlank(captcha, CAPTCHA_EXPIRED);
        ValidationUtils.throwIfNotEqualIgnoreCase(req.getCaptcha(), captcha, CAPTCHA_ERROR);
        RedisUtils.delete(captchaKey);
    }

    @Override
    public AuthTypeEnum getAuthType() {
        return AuthTypeEnum.EMAIL;
    }
}