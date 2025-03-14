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

package top.continew.admin.cms;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.lang.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Html 工具类
 *
 * @author PONY
 */
public class HtmlParserUtils {
    /**
     * 提取html中图片、视频和链接的URL
     */
    public static List<String> getUrls(@Nullable String html) {
        List<String> urls = new ArrayList<>();
        if (StringUtils.isBlank(html)) {
            return urls;
        }
        Document doc = Jsoup.parseBodyFragment(html);
        doc.select("img,source,a").forEach(element -> {
            switch (element.tagName()) {
                case "img":
                case "source": {
                    Optional.of(element.attr("src")).filter(url -> !url.isEmpty()).ifPresent(urls::add);
                    break;
                }
                case "a": {
                    Optional.of(element.attr("href")).filter(url -> !url.isEmpty()).ifPresent(urls::add);
                    break;
                }
                default:
            }
        });
        return urls;
    }

    private HtmlParserUtils() {
    }
}
