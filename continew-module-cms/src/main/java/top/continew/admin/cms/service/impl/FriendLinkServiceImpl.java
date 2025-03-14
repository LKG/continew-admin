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

package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.FriendLinkMapper;
import top.continew.admin.cms.model.entity.FriendLinkDO;
import top.continew.admin.cms.model.query.FriendLinkQuery;
import top.continew.admin.cms.model.req.FriendLinkReq;
import top.continew.admin.cms.model.resp.FriendLinkDetailResp;
import top.continew.admin.cms.model.resp.FriendLinkResp;
import top.continew.admin.cms.service.FriendLinkService;

/**
 * 友情链接业务实现
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Service
@RequiredArgsConstructor
public class FriendLinkServiceImpl extends BaseServiceImpl<FriendLinkMapper, FriendLinkDO, FriendLinkResp, FriendLinkDetailResp, FriendLinkQuery, FriendLinkReq> implements FriendLinkService {}