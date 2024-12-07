-- liquibase formatted sql

-- changeset gg:1
-- comment 初始化多租户插件
-- 初始化表结构

CREATE TABLE IF NOT EXISTS  `sys_tenant`  (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '租户编号',
`name` varchar(30) CHARACTER SET utf8mb4  NOT NULL COMMENT '租户名',
`contact_user_id` bigint NULL DEFAULT NULL COMMENT '联系人的用户编号',
`contact_name` varchar(30) CHARACTER SET utf8mb4  NOT NULL COMMENT '联系人',
`contact_mobile` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '联系手机',
`status` tinyint NOT NULL DEFAULT 0 COMMENT '租户状态（0正常 1停用）',
`website` varchar(256) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '绑定域名',
`package_id` bigint NOT NULL COMMENT '租户套餐编号',
`expire_time` datetime NOT NULL COMMENT '过期时间',
`account_count` int NOT NULL COMMENT '账号数量',
`creator` varchar(64) CHARACTER SET utf8mb4  NOT NULL DEFAULT '' COMMENT '创建者',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updater` varchar(64) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '更新者',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 162 CHARACTER SET = utf8mb4 COMMENT = '租户表';

BEGIN;
INSERT INTO `sys_tenant` (`id`, `name`, `contact_user_id`, `contact_name`, `contact_mobile`, `status`, `website`, `package_id`, `expire_time`, `account_count`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (1, '芋道源码', NULL, '芋艿', '17321315478', 0, 'www.gongwk.cn', 0, '2099-02-19 17:14:16', 9999, '1', '2021-01-05 17:03:47', '1', '2023-11-06 11:41:41', b'0');
INSERT INTO `sys_tenant` (`id`, `name`, `contact_user_id`, `contact_name`, `contact_mobile`, `status`, `website`, `package_id`, `expire_time`, `account_count`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (121, '小租户', 110, '小王2', '15601691300', 0, 'www.gongwk.com', 111, '2025-03-11 00:00:00', 20, '1', '2022-02-22 00:56:14', '1', '2024-07-20 22:21:53', b'0');
INSERT INTO `sys_tenant` (`id`, `name`, `contact_user_id`, `contact_name`, `contact_mobile`, `status`, `website`, `package_id`, `expire_time`, `account_count`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (122, '测试租户', 113, '芋道', '15601691300', 0, 'test.gongwk.cn', 111, '2022-04-29 00:00:00', 50, '1', '2022-03-07 21:37:58', '1', '2024-09-22 12:10:50', b'0');
COMMIT;

CREATE TABLE IF NOT EXISTS  `sys_tenant_package`  (
`id` bigint NOT NULL AUTO_INCREMENT COMMENT '套餐编号',
`name` varchar(30) CHARACTER SET utf8mb4  NOT NULL COMMENT '套餐名',
`status` tinyint NOT NULL DEFAULT 0 COMMENT '租户状态（0正常 1停用）',
`remark` varchar(256) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '备注',
`menu_ids` varchar(4096) CHARACTER SET utf8mb4  NOT NULL COMMENT '关联的菜单编号',
`creator` varchar(64) CHARACTER SET utf8mb4  NOT NULL DEFAULT '' COMMENT '创建者',
`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`updater` varchar(64) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '更新者',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
`deleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否删除',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 112 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '租户套餐表';

-- ----------------------------
-- Records of sys_tenant_package
-- ----------------------------
BEGIN;
INSERT INTO `sys_tenant_package` (`id`, `name`, `status`, `remark`, `menu_ids`, `creator`, `create_time`, `updater`, `update_time`, `deleted`) VALUES (111, '普通套餐', 0, '小功能', '[1,2,5,1031,1032,1033,1034,1035,1036,1037,1038,1039,1050,1051,1052,1053,1054,1056,1057,1058,1059,1060,1063,1064,1065,1066,1067,1070,1075,1077,1078,1082,1083,1084,1085,1086,1087,1088,1089,1090,1091,1092,1118,1119,1120,100,101,102,103,106,107,110,111,112,113,1138,114,1139,115,1140,116,1141,1142,1143,2713,2714,2715,2716,2717,2718,2720,1185,2721,1186,2722,1187,2723,1188,2724,1189,2725,1190,2726,1191,2727,2472,1192,2728,1193,2729,1194,2730,1195,2731,1196,2732,1197,2733,2478,1198,2734,2479,1199,2735,2480,1200,2481,1201,2482,1202,2483,2739,2484,2740,2485,2486,2487,1207,2488,1208,2489,1209,2490,1210,2491,1211,2492,1212,2493,1213,2494,2495,1215,1216,2497,1217,1218,1219,1220,1221,1222,1224,1225,1226,1227,1228,1229,1237,1238,1239,1240,1241,1242,1243,2525,1255,1256,1001,1257,1002,1258,1003,1259,1004,1260,1005,1006,1007,1008,1009,1010,1011,1012,1013,1014,1015,1016,1017,1018,1019,1020]', '1', '2022-02-22 00:54:00', '1', '2024-07-13 22:37:24', b'0');
COMMIT;