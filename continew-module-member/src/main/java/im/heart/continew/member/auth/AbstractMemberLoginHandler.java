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

package im.heart.continew.member.auth;

import cn.dev33.satoken.stp.SaLoginModel;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import im.heart.continew.member.auth.model.req.MemberLoginReq;
import im.heart.continew.member.context.MemberContext;
import im.heart.continew.member.context.MemberContextHolder;
import im.heart.continew.member.model.entity.MemberDO;
import im.heart.continew.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import top.continew.admin.common.context.UserExtraContext;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.system.model.resp.ClientResp;
import top.continew.admin.system.service.OptionService;
import top.continew.starter.core.validation.CheckUtils;
import top.continew.starter.core.validation.Validator;
import top.continew.starter.web.util.SpringWebUtils;

import java.util.concurrent.CompletableFuture;

import static top.continew.admin.system.enums.PasswordPolicyEnum.PASSWORD_EXPIRATION_DAYS;

/**
 * 登录处理器基类
 *
 * @author KAI
 * @author Charles7c
 * @since 2024/12/22 14:52
 */
@Component
public abstract class AbstractMemberLoginHandler<T extends MemberLoginReq> implements MemberLoginHandler<T> {

    @Resource
    protected OptionService optionService;
    @Resource
    protected MemberService memberService;

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    protected static final String CAPTCHA_EXPIRED = "验证码已失效";
    protected static final String CAPTCHA_ERROR = "验证码不正确";
    protected static final String CLIENT_ID = "clientId";

    @Override
    public void preLogin(T req, ClientResp client, HttpServletRequest request) {
        // 参数校验
        Validator.validate(req);
    }

    @Override
    public void postLogin(T req, ClientResp client, HttpServletRequest request) {
    }

    /**
     * 认证
     *
     * @param user   用户信息
     * @param client 终端信息
     * @return token 令牌信息
     */
    protected String authenticate(MemberDO member, ClientResp client) {
        // 获取权限、角色、密码过期天数
        Long userId = member.getId();
        CompletableFuture<Integer> passwordExpirationDaysFuture = CompletableFuture.supplyAsync(() -> optionService
            .getValueByCode2Int(PASSWORD_EXPIRATION_DAYS.name()));
        CompletableFuture.allOf(passwordExpirationDaysFuture);
        MemberContext memberContext = new MemberContext(passwordExpirationDaysFuture.join());
        BeanUtil.copyProperties(member, memberContext);
        // 设置登录配置参数
        SaLoginModel model = new SaLoginModel();
        model.setActiveTimeout(client.getActiveTimeout());
        model.setTimeout(client.getTimeout());
        model.setDevice(client.getClientType());
        memberContext.setClientType(client.getClientType());
        model.setExtra(CLIENT_ID, client.getClientId());
        memberContext.setClientId(client.getClientId());
        // 登录并缓存用户信息
        StpUtil.login(memberContext.getId(), model.setExtraData(BeanUtil.beanToMap(new UserExtraContext(SpringWebUtils
            .getRequest()))));
        MemberContextHolder.setContext(memberContext);
        return StpUtil.getTokenValue();
    }

    /**
     * 检查用户状态
     *
     * @param user 用户信息
     */
    protected void checkUserStatus(MemberDO member) {
        CheckUtils.throwIfEqual(DisEnableStatusEnum.DISABLE, member.getStatus(), "此账号已被禁用，如有疑问，请联系管理员");
    }
}