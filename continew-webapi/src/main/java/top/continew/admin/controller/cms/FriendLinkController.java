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

package top.continew.admin.controller.cms;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RestController;
import top.continew.admin.cms.model.query.FriendLinkQuery;
import top.continew.admin.cms.model.req.FriendLinkReq;
import top.continew.admin.cms.model.resp.FriendLinkDetailResp;
import top.continew.admin.cms.model.resp.FriendLinkResp;
import top.continew.admin.cms.service.FriendLinkService;
import top.continew.admin.common.controller.BaseController;
import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.enums.Api;

/**
 * 友情链接管理 API
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Tag(name = "友情链接管理 API")
@RestController
@CrudRequestMapping(value = "/cms/friendLink", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE,
    Api.EXPORT})
public class FriendLinkController extends BaseController<FriendLinkService, FriendLinkResp, FriendLinkDetailResp, FriendLinkQuery, FriendLinkReq> {}