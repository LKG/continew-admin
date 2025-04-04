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

package im.heart.continew.member.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.xkcoding.justauth.AuthRequestFactory;
import im.heart.continew.member.auth.model.req.MemberLoginReq;
import im.heart.continew.member.auth.model.resp.MemberInfoResp;
import im.heart.continew.member.auth.model.resp.MemberLoginResp;
import im.heart.continew.member.auth.service.MemberAuthService;
import im.heart.continew.member.context.MemberContext;
import im.heart.continew.member.context.MemberContextHolder;
import im.heart.continew.member.model.resp.MemberDetailResp;
import im.heart.continew.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.continew.admin.auth.model.resp.SocialAuthAuthorizeResp;
import top.continew.starter.core.exception.BadRequestException;
import im.heart.continew.member.auth.model.resp.RouteResp;

import java.util.List;

/**
 * 认证 API
 *
 * @author Charles7c
 * @since 2022/12/21 20:37
 */
@Tag(name = "认证 API")
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class MemberAuthController {

    private final MemberAuthService memberAuthService;
    private final MemberService memberService;
    private final AuthRequestFactory authRequestFactory;

    @SaIgnore
    @Operation(summary = "登录", description = "用户登录")
    @PostMapping("/login")
    public MemberLoginResp login(@Validated @RequestBody MemberLoginReq req, HttpServletRequest request) {
        return memberAuthService.login(req, request);
    }

    @Operation(summary = "登出", description = "注销用户的当前登录")
    @Parameter(name = "Authorization", description = "令牌", required = true, example = "Bearer xxxx-xxxx-xxxx-xxxx", in = ParameterIn.HEADER)
    @PostMapping("/logout")
    public Object logout() {
        Object loginId = StpUtil.getLoginId(-1L);
        StpUtil.logout();
        return loginId;
    }

    @SaIgnore
    @Operation(summary = "三方账号登录授权", description = "三方账号登录授权")
    @Parameter(name = "source", description = "来源", example = "gitee", in = ParameterIn.PATH)
    @GetMapping("/{source}")
    public SocialAuthAuthorizeResp authorize(@PathVariable String source) {
        AuthRequest authRequest = this.getAuthRequest(source);
        return SocialAuthAuthorizeResp.builder()
            .authorizeUrl(authRequest.authorize(AuthStateUtils.createState()))
            .build();
    }

    @Operation(summary = "获取用户信息", description = "获取登录用户信息")
    @GetMapping("/user/info")
    public MemberInfoResp getUserInfo() {
        MemberContext memberContext = MemberContextHolder.getContext();
        MemberDetailResp memberDetailResp = memberService.get(memberContext.getId());
        MemberInfoResp userInfoResp = BeanUtil.copyProperties(memberDetailResp, MemberInfoResp.class);
        userInfoResp.setPwdExpired(memberContext.isPasswordExpired());
        return userInfoResp;
    }

    @Operation(summary = "获取路由信息", description = "获取登录用户的路由信息")
    @GetMapping("/user/route")
    public List<RouteResp> listRoute() {
        return memberAuthService.buildRouteTree(MemberContextHolder.getUserId());
    }

    private AuthRequest getAuthRequest(String source) {
        try {
            return authRequestFactory.get(source);
        } catch (Exception e) {
            throw new BadRequestException("暂不支持 [%s] 平台账号登录".formatted(source));
        }
    }
}
