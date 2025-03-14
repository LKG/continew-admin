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

package top.continew.admin.cms.support;

/**
 * 定义两个常用的 @JsonView
 * <p>
 * SpringBoot配置 {@code spring.jackson.mapper.DEFAULT_VIEW_INCLUSION: true} 可以很方便的对API返回数据进行不同的序列化处理
 * <p>
 * 一般列表数据的序列化不包含大字段数据（如文章正文）以免数据量过于庞大。而单个对象的序列化则需要包含全部字段。
 *
 * @author gg
 */
public interface Views {
    /**
     * 一般用于列表(List)数据的序列化
     */
    interface List {
    }

    /**
     * 一般用于详情数据的序列化
     */
    interface Whole extends List {
    }

}
