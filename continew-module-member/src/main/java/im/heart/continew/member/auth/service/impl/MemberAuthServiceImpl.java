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

package im.heart.continew.member.auth.service.impl;

import im.heart.continew.member.auth.MemberLoginHandler;
import im.heart.continew.member.auth.MemberLoginHandlerFactory;
import im.heart.continew.member.auth.enums.AuthTypeEnum;
import im.heart.continew.member.auth.model.req.MemberLoginReq;
import im.heart.continew.member.auth.model.resp.MemberLoginResp;
import im.heart.continew.member.auth.model.resp.RouteResp;
import im.heart.continew.member.auth.service.MemberAuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.continew.admin.common.enums.DisEnableStatusEnum;
import top.continew.admin.system.model.resp.ClientResp;
import top.continew.admin.system.service.ClientService;
import top.continew.starter.core.validation.ValidationUtils;
import top.continew.starter.extension.crud.autoconfigure.CrudProperties;

import java.util.List;

/**
 * 认证业务实现
 *
 * @author Charles7c
 * @since 2022/12/21 21:49
 */
@Service
@RequiredArgsConstructor
public class MemberAuthServiceImpl implements MemberAuthService {

    private final MemberLoginHandlerFactory memberLoginHandlerFactory;
    private final ClientService clientService;
    private final CrudProperties crudProperties;

    @Override
    public MemberLoginResp login(MemberLoginReq req, HttpServletRequest request) {
        AuthTypeEnum authType = req.getAuthType();
        // 校验终端
        ClientResp client = clientService.getByClientId(req.getClientId());
        ValidationUtils.throwIfNull(client, "终端不存在");
        ValidationUtils.throwIf(DisEnableStatusEnum.DISABLE.equals(client.getStatus()), "终端已禁用");
        ValidationUtils.throwIf(!client.getAuthType().contains(authType.getValue()), "该终端暂未授权 [{}] 认证", authType
            .getDescription());
        // 获取处理器
        MemberLoginHandler<MemberLoginReq> loginHandler = memberLoginHandlerFactory.getHandler(authType);
        // 登录前置处理
        loginHandler.preLogin(req, client, request);
        // 登录
        MemberLoginResp loginResp = loginHandler.login(req, client, request);
        // 登录后置处理
        loginHandler.postLogin(req, client, request);
        return loginResp;
    }

    @Override
    public List<RouteResp> buildRouteTree(Long userId) {
        // 构建路由树
        return null;
    }
}
