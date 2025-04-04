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

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.json.JSONUtil;
import com.xkcoding.justauth.AuthRequestFactory;
import im.heart.continew.member.auth.AbstractMemberLoginHandler;
import im.heart.continew.member.auth.enums.AuthTypeEnum;
import im.heart.continew.member.auth.model.req.SocialLoginReq;
import im.heart.continew.member.auth.model.resp.MemberLoginResp;
import im.heart.continew.member.model.entity.MemberDO;
import im.heart.continew.member.model.entity.MemberSocialDO;
import im.heart.continew.member.service.MemberSocialService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthUser;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.stereotype.Component;
import top.continew.admin.common.constant.RegexConstants;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.common.enums.GenderEnum;
import top.continew.admin.system.enums.MessageTemplateEnum;
import top.continew.admin.system.enums.MessageTypeEnum;
import top.continew.admin.system.model.req.MessageReq;
import top.continew.admin.system.model.resp.ClientResp;
import top.continew.admin.system.service.MessageService;
import top.continew.starter.core.autoconfigure.project.ProjectProperties;
import top.continew.starter.core.exception.BadRequestException;
import top.continew.starter.core.validation.ValidationUtils;
import top.continew.starter.messaging.websocket.util.WebSocketUtils;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 第三方账号登录处理器
 *
 * @author KAI
 * @author Charles7c
 * @since 2024/12/25 14:21
 */
@Component
@RequiredArgsConstructor
public class SocialLoginHandler extends AbstractMemberLoginHandler<SocialLoginReq> {

    private final AuthRequestFactory authRequestFactory;
    private final MemberSocialService memberSocialService;
    private final MessageService messageService;
    private final ProjectProperties projectProperties;

    @Override
    public MemberLoginResp login(SocialLoginReq req, ClientResp client, HttpServletRequest request) {
        // 获取第三方登录信息
        AuthRequest authRequest = this.getAuthRequest(req.getSource());
        AuthCallback callback = new AuthCallback();
        callback.setCode(req.getCode());
        callback.setState(req.getState());
        AuthResponse<AuthUser> response = authRequest.login(callback);
        ValidationUtils.throwIf(!response.ok(), response.getMsg());
        AuthUser authUser = response.getData();
        // 如未绑定则自动注册新用户，保存或更新关联信息
        String source = authUser.getSource();
        String openId = authUser.getUuid();
        MemberSocialDO memberSocial = memberSocialService.getBySourceAndOpenId(source, openId);
        MemberDO member;
        if (null == memberSocial) {
            String username = authUser.getUsername();
            String nickname = authUser.getNickname();
            MemberDO existsMember = memberService.getByUsername(username);
            String randomStr = RandomUtil.randomString(RandomUtil.BASE_CHAR, 5);
            if (null != existsMember || !ReUtil.isMatch(RegexConstants.USERNAME, username)) {
                username = randomStr + IdUtil.fastSimpleUUID();
            }
            if (!ReUtil.isMatch(RegexConstants.GENERAL_NAME, nickname)) {
                nickname = source.toLowerCase() + randomStr;
            }
            member = new MemberDO();
            member.setUsername(username);
            member.setNickname(nickname);
            member.setGender(GenderEnum.valueOf(authUser.getGender().name()));
            member.setAvatar(authUser.getAvatar());
            member.setStatus(DisEnableStatusEnum.ENABLE);
            memberService.save(member);
            Long userId = member.getId();
            memberSocial = new MemberSocialDO();
            memberSocial.setUserId(userId);
            memberSocial.setSource(source);
            memberSocial.setOpenId(openId);
            this.sendSecurityMsg(member);
        } else {
            member = BeanUtil.copyProperties(memberService.getById(memberSocial.getUserId()), MemberDO.class);
        }
        // 检查用户状态
        super.checkUserStatus(member);
        memberSocial.setMetaJson(JSONUtil.toJsonStr(authUser));
        memberSocial.setLastLoginTime(LocalDateTime.now());
        memberSocialService.saveOrUpdate(memberSocial);
        // 执行认证
        String token = super.authenticate(member, client);
        return MemberLoginResp.builder().token(token).build();
    }

    @Override
    public void preLogin(SocialLoginReq req, ClientResp client, HttpServletRequest request) {
        super.preLogin(req, client, request);
        if (StpUtil.isLogin()) {
            StpUtil.logout();
        }
    }

    @Override
    public AuthTypeEnum getAuthType() {
        return AuthTypeEnum.SOCIAL;
    }

    /**
     * 获取 AuthRequest
     *
     * @param source 平台名称
     * @return AuthRequest
     */
    private AuthRequest getAuthRequest(String source) {
        try {
            return authRequestFactory.get(source);
        } catch (Exception e) {
            throw new BadRequestException("暂不支持 [%s] 平台账号登录".formatted(source));
        }
    }

    /**
     * 发送安全消息
     *
     * @param member 用户信息
     */
    private void sendSecurityMsg(MemberDO member) {
        MessageReq req = new MessageReq();
        MessageTemplateEnum socialRegister = MessageTemplateEnum.SOCIAL_REGISTER;
        req.setTitle(socialRegister.getTitle().formatted(projectProperties.getName()));
        req.setContent(socialRegister.getContent().formatted(member.getNickname()));
        req.setType(MessageTypeEnum.SECURITY);
        messageService.add(req, CollUtil.toList(member.getId()));
        List<String> tokenList = StpUtil.getTokenValueListByLoginId(member.getId());
        for (String token : tokenList) {
            WebSocketUtils.sendMessage(token, "1");
        }
    }
}
