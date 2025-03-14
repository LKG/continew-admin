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

package top.continew.admin.cms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serializable;

/**
 * 栏目扩展数据实体类
 *
 * @author PONY
 */
@Schema(name = "Channel.ChannelExt")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("handler")
@Data
@TableName("cms_channel_ext")
public class ChannelExt extends BaseDO implements Serializable {

    /**
     * 静态页文件
     */
    @Length(max = 255)
    @Nullable
    @Schema(description = "静态页文件")
    private String staticFile;

    /**
     * 手机端静态页文件
     */
    @Length(max = 255)
    @Nullable
    @Schema(description = "手机端静态页文件")
    private String mobileStaticFile;

    /**
     * 编辑器类型(1:富文本编辑器,2:Markdown编辑器)
     */
    @NotNull
    @Schema(description = "编辑器类型(1:富文本编辑器,2:Markdown编辑器)")
    private Short editorType = 1;

    /**
     * 正文
     */
    @Nullable
    @Schema(description = "正文")
    private String text;

    /**
     * Markdown正文
     */
    @Nullable
    @Schema(description = "Markdown正文")
    private String markdown;

}