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

package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 友情链接信息
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@Schema(description = "友情链接信息")
public class FriendLinkResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    @Schema(description = "友链名称")
    private String name;

    /**
     * 友链地址
     */
    @Schema(description = "友链地址")
    private String url;

    /**
     * 
     */
    @Schema(description = "")
    private Long updateUser;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    private String checkStatus;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime expiryTime;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * logo
     */
    @Schema(description = "logo")
    private String logo;

    /**
     * 上链地址
     */
    @Schema(description = "上链地址")
    private String requestUrl;
}