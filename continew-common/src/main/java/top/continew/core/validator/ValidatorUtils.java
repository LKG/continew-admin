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

package top.continew.core.validator;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author gg
 *         验证工具类
 */
@Slf4j
public class ValidatorUtils implements Regular {
    /**
     *
     * 判断是不是一个合法的电子邮件地址
     * 
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return false;
        }
        return EMAIL_ER.matcher(email).matches();
    }

    public static boolean isNumber(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return NUMBER_ER.matcher(str).matches();
    }

    /**
     *
     * 判断是否包含中文
     * 
     * @param str
     * @return
     */
    public static boolean isContainsChinese(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return CHINES_ER.matcher(str).find();
    }

    /**
     *
     * 判断是否为日期格式
     * 
     * @param str
     * @return
     */
    public static boolean isDateTime(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        return DATETIME_ER.matcher(str).matches();
    }

    /**
     *
     * 判断是否为电话号码
     * 
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        if (StringUtils.isBlank(phone)) {
            return false;
        }
        return PHONE_ER.matcher(phone).matches();
    }

    /**
     * 判断是否为IP地址
     * 
     * @param ip
     * @return
     */
    public static boolean isIpAddress(String ip) {
        if (StringUtils.isBlank(ip)) {
            return false;
        }
        return IP_ER.matcher(ip).matches();
    }

    /**
     *
     * 判断是否为url
     * 
     * @param url
     * @return
     */
    public static boolean isUrl(String url) {
        if (StringUtils.isBlank(url)) {
            return false;
        }
        return URL_ER.matcher(url).matches();
    }

    /**
     *
     * 判断是否为身份证号码
     * 
     * @param idCard
     * @return
     */
    public static boolean isIdCard(String idCard) {
        if (StringUtils.isBlank(idCard)) {
            return false;
        }
        return ID_CARD_ER.matcher(idCard).matches();
    }
}
