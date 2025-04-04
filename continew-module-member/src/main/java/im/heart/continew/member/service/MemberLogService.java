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

import im.heart.continew.member.model.query.MemberLogQuery;
import im.heart.continew.member.model.resp.MemberLogDetailResp;
import im.heart.continew.member.model.resp.MemberLogResp;
import top.continew.starter.extension.crud.model.query.PageQuery;
import top.continew.starter.extension.crud.model.resp.PageResp;

/**
 * 系统日志业务接口
 *
 * @author Charles7c
 * @since 2022/12/23 20:12
 */
public interface MemberLogService {

    /**
     * 分页查询列表
     *
     * @param query     查询条件
     * @param pageQuery 分页查询条件
     * @return 分页列表信息
     */
    PageResp<MemberLogResp> page(MemberLogQuery query, PageQuery pageQuery);

    /**
     * 查询详情
     *
     * @param id ID
     * @return 详情信息
     */
    MemberLogDetailResp get(Long id);

}
