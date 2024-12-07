-- liquibase formatted sql

-- changeset GG:2
-- comment 初始化代码生成插件
-- 初始化表结构
-- ----------------------------
CREATE TABLE IF NOT EXISTS  `crm_customer`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`customer_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'客户名称',
`followup` int NULL DEFAULT NULL COMMENT'跟进状态 0未跟进1已跟进',
`is_lock` int NOT NULL DEFAULT 0 COMMENT'1锁定',
`next_time` datetime NULL DEFAULT NULL COMMENT'下次联系时间',
`deal_status` int NULL DEFAULT 0 COMMENT'成交状态 0 未成交 1 已成交',
`deal_time` datetime NULL DEFAULT NULL COMMENT'成交时间',
`contacts_id` bigint(20) NULL DEFAULT NULL COMMENT'首要联系人ID',
`mobile` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'手机',
`telephone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'电话',
`website` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'网址',
`email` varchar(225) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'邮箱',
`remark` varchar(3000) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'备注',
`owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT'负责人ID',
`ro_user_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'只读权限',
`rw_user_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'读写权限',
`address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'省市区',
`location` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'定位信息',
`detail_address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'详细地址',
`lng` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'地理位置经度',
`lat` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'地理位置维度',
`create_user` bigint(20) NULL DEFAULT NULL COMMENT'创建人ID',
`create_time` datetime NOT NULL COMMENT'创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT'更新时间',
`update_user` bigint(20) NULL DEFAULT NULL COMMENT'更新人ID',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT'批次 比如附件批次',
`status` int NULL DEFAULT 1 COMMENT'客户状态 1 正常 2锁定 3删除',
`last_time` datetime NULL DEFAULT NULL COMMENT'最后跟进时间',
`pool_time` datetime NULL DEFAULT NULL COMMENT'放入公海时间',
`is_receive` int NULL DEFAULT NULL COMMENT'1 分配 2 领取',
`last_content` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'最后一条跟进记录',
`receive_time` datetime NULL DEFAULT NULL COMMENT'接收到客户时间',
`pre_owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT'进入公海前负责人id',
PRIMARY KEY (`id`) USING BTREE,
INDEX `update_time`(`update_time`) USING BTREE,
INDEX `owner_user_id`(`owner_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='客户表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_customer_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
  `value` longtext CHARACTER SET utf8mb4  NULL,
  `create_time` datetime NOT NULL,
  `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `batch_id`(`batch_id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='客户扩展字段数据表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_customer_pool`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `pool_name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'公海名称',
  `admin_user_id` longtext CHARACTER SET utf8mb4  NOT NULL COMMENT'管理员 “,”分割',
  `member_user_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'公海规则员工成员 “,”分割',
  `member_dept_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'公海规则部门成员 “,”分割',
  `status` int NOT NULL DEFAULT 1 COMMENT'状态 0 停用 1启用',
  `pre_owner_setting` int NOT NULL COMMENT'前负责人领取规则 0不限制 1限制',
  `pre_owner_setting_day` int NULL DEFAULT NULL COMMENT'前负责人领取规则限制天数',
  `receive_setting` int NOT NULL COMMENT'是否限制领取频率 0不限制 1限制',
  `receive_num` int NULL DEFAULT NULL COMMENT'领取频率规则',
  `remind_setting` int NOT NULL COMMENT'是否设置提前提醒 0不开启 1开启',
  `remind_day` int NULL DEFAULT NULL COMMENT'提醒规则天数',
  `put_in_rule` int NOT NULL COMMENT'收回规则 0不自动收回 1自动收回',
  `create_user` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34553 CHARACTER SET = utf8mb4 COMMENT ='公海表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_customer_pool
-- ----------------------------
INSERT INTO `crm_customer_pool` VALUES (34552,'系统默认公海','14773','14773','', 1, 0, NULL, 0, NULL, 0, NULL, 0, 0,'2019-06-30 18:13:08');

CREATE TABLE IF NOT EXISTS`crm_customer_pool_field_setting`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `pool_id` bigint(20) NOT NULL COMMENT'公海id',
 `field_id` bigint(20) NULL DEFAULT NULL COMMENT'字段id',
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段中文名称',
 `field_name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
 `type` int NOT NULL COMMENT'字段类型 1 单行文本 2 多行文本 3 单选 4 日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
 `is_hidden` int NOT NULL DEFAULT 0 COMMENT'是否隐藏 0不隐藏 1隐藏',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 439856 CHARACTER SET = utf8mb4 COMMENT ='公海列表页字段设置表' ROW_FORMAT = Dynamic;

INSERT INTO `crm_customer_pool_field_setting` VALUES (439842, 34552, 1101827,'客户名称','customerName', 1, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439843, 34552, 1101829,'手机','mobile', 7, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439844, 34552, 1101830,'电话','telephone', 1, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439845, 34552, 1101831,'网址','website', 1, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439846, 34552, 1101834,'下次联系时间','nextTime', 13, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439847, 34552, 1101835,'备注','remark', 1, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439848, 34552, 1101833,'客户级别','level', 3, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439849, 34552, 1101828,'客户来源','source', 3, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439850, 34552, 1101832,'客户行业','industry', 3, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439851, 34552, NULL,'成交状态','dealStatus', 3, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439852, 34552, NULL,'最后跟进时间','lastTime', 4, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439853, 34552, NULL,'更新时间','updateTime', 4, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439854, 34552, NULL,'创建时间','createTime', 4, 0);
INSERT INTO `crm_customer_pool_field_setting` VALUES (439855, 34552, NULL,'创建人','createUserName', 1, 0);


CREATE TABLE IF NOT EXISTS  `crm_customer_pool_field_sort`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `pool_id` bigint(20) NOT NULL COMMENT'公海id',
  `user_id` bigint(20) NOT NULL COMMENT'用户id',
  `field_id` bigint(20) NULL DEFAULT NULL COMMENT'字段id',
  `field_name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段中文名称',
  `type` int NOT NULL COMMENT'字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
  `sort` int NOT NULL COMMENT'字段排序',
  `is_hidden` int NOT NULL COMMENT'是否隐藏 0、不隐藏 1、隐藏',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='公海列表页字段排序表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_customer_pool_relation`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`customer_id` bigint(20)  NOT NULL COMMENT'客户id',
`pool_id` bigint(20)  NOT NULL COMMENT'公海id',
PRIMARY KEY (`id`) USING BTREE,
INDEX `pool_id`(`pool_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='客户公海关联表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_customer_pool_rule`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`pool_id` bigint(20) NOT NULL COMMENT'公海id',
`type` int NOT NULL COMMENT'收回规则判断类型 1跟进记录 2商机 3成交状态',
`deal_handle` int NULL DEFAULT NULL COMMENT'已成交客户是否进入公海 0不进入 1进入',
`business_handle` int NULL DEFAULT NULL COMMENT'有商机客户是否进入公海 0不进入 1进入',
`customer_level_setting` int NOT NULL COMMENT'客户级别设置 1全部 2根据级别分别设置',
`level` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'客户级别 1全部',
`limit_day` int NOT NULL COMMENT'公海规则限制天数',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='公海收回规则表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS  `crm_customer_setting`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`setting_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'规则名称',
`customer_num` int NULL DEFAULT NULL COMMENT'可拥有客户数量',
`customer_deal` int NULL DEFAULT 0 COMMENT'成交客户是否占用数量 0 不占用 1 占用',
`type` int NULL DEFAULT NULL COMMENT'类型 1 拥有客户数限制 2 锁定客户数限制',
`create_time` datetime NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='员工拥有以及锁定客户数限制' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_customer_setting_user`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`setting_id` bigint(20) NOT NULL COMMENT'客户规则限制ID',
`user_id` bigint(20) NULL DEFAULT NULL COMMENT'用户id',
`dept_id` bigint(20) NULL DEFAULT NULL COMMENT'部门ID',
`type` int NULL DEFAULT NULL COMMENT'1 员工 2 部门',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='员工拥有以及锁定客户员工关联表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS`crm_customer_user_star`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`user_id` bigint(20) NOT NULL COMMENT'用户id',
`customer_id` bigint(20) NOT NULL COMMENT'客户id',
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `user_id`(`user_id`, `customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='用户客户标星关系表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_call_record` (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `number` VARCHAR ( 20 ) CHARACTER SET utf8mb4  NOT NULL COMMENT'电话号码',
 `start_time` DATETIME ( 0 ) NULL DEFAULT NULL COMMENT'开始振铃时间',
 `answer_time` DATETIME ( 0 ) NULL DEFAULT NULL COMMENT'接通时间',
 `end_time` DATETIME ( 0 ) NULL DEFAULT NULL COMMENT'结束时间',
 `talk_time` int NULL DEFAULT 0 COMMENT'通话时长（秒）',
 `dial_time` int NULL DEFAULT 0 COMMENT'摘机时长',
 `state` int NULL DEFAULT NULL COMMENT'通话状态 (0未振铃，1未接通，2接通，3呼入未接通)',
 `type` int NULL DEFAULT NULL COMMENT'通话类型 (0呼出，1呼入)',
 `model` varchar(15) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'关联模块 leads，customer，contacts',
 `model_id` bigint(20) NULL DEFAULT NULL COMMENT'关联模块ID',
 `file_path` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'录音文件路径',
 `size` int NULL DEFAULT 0 COMMENT'录音文件大小',
 `file_name` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'文件名称',
 `call_upload` TINYINT ( 1 ) NULL DEFAULT 0 COMMENT'0：CRM服务器; 1：上传至阿里云',
 `create_time` DATETIME ( 0 ) NULL DEFAULT NULL COMMENT'创建时间',
 `update_time` DATETIME ( 0 ) NULL DEFAULT NULL COMMENT'修改时间',
 `update_user` bigint(20)DEFAULT NULL COMMENT '修改人',
 `create_user` bigint(20) NULL DEFAULT NULL COMMENT'创建人ID',
 `owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT'负责人ID',
 `batch_id` VARCHAR ( 32 ) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'批次',
 PRIMARY KEY ( `id` ) USING BTREE
) ENGINE = INNODB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='通话记录' ROW_FORMAT = Dynamic;
CREATE TABLE IF NOT EXISTS `crm_business`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `type_id` bigint(20) NULL DEFAULT NULL COMMENT'商机状态组',
  `status_id` int NULL DEFAULT NULL COMMENT'销售阶段',
  `next_time` datetime NULL DEFAULT NULL COMMENT'下次联系时间',
  `customer_id` bigint(20) NULL DEFAULT NULL COMMENT'客户ID',
  `contacts_id` bigint(20) NULL DEFAULT NULL COMMENT'首要联系人ID',
  `deal_date` datetime NULL DEFAULT NULL COMMENT'预计成交日期',
  `business_name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'商机名称',
  `money` decimal(18, 2) NULL DEFAULT NULL COMMENT'商机金额',
  `discount_rate` decimal(10, 2) NULL DEFAULT NULL COMMENT'整单折扣',
  `total_price` decimal(17, 2) NULL DEFAULT NULL COMMENT'产品总金额',
  `remark` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'备注',
  `owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT'负责人ID',
  `create_user` bigint(20) NOT NULL COMMENT'创建人ID',
  `create_time` datetime NOT NULL COMMENT'创建时间',
  `update_user` bigint(20) NOT NULL COMMENT'创建人ID',
  `update_time` datetime NULL DEFAULT NULL COMMENT'更新时间',
  `batch_id` varchar(32) CHARACTER SET utf8  NULL DEFAULT NULL COMMENT'批次 比如附件批次',
  `ro_user_id` longtext CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'只读权限',
  `rw_user_id` longtext CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'读写权限',
  `is_end` int NOT NULL DEFAULT 0 COMMENT'1赢单2输单3无效',
  `status_remark` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT'',
  `status` int NULL DEFAULT 1 COMMENT'状态',
  `last_time` datetime NULL DEFAULT NULL COMMENT'最后跟进时间',
  `followup` int NULL DEFAULT NULL COMMENT'0 未跟进 1 已跟进',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `owner_user_id`(`owner_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='商机表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_business_data`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_id` bigint(20)  NOT NULL,
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
 `value` longtext CHARACTER SET utf8mb4  NULL,
 `create_time` datetime NOT NULL,
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `batch_id`(`batch_id`) USING BTREE,
 INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='商机扩展字段数据表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_business_change`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `business_id` bigint(20) NOT NULL COMMENT'商机ID',
  `status_id` bigint(20) NOT NULL COMMENT'阶段ID',
  `create_time` datetime NOT NULL COMMENT'创建时间',
  `create_user` bigint(20) NOT NULL COMMENT'创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='商机阶段变化表' ROW_FORMAT = Dynamic;



CREATE TABLE IF NOT EXISTS  `crm_business_product`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`business_id` bigint(20)  NOT NULL COMMENT'商机ID',
`product_id` bigint(20)  NOT NULL COMMENT'产品ID',
`price` decimal(18, 2) NOT NULL COMMENT'产品单价',
`sales_price` decimal(18, 2) NOT NULL COMMENT'销售价格',
`num` decimal(10, 2) NOT NULL COMMENT'数量',
`discount` int NOT NULL COMMENT'折扣',
`subtotal` decimal(18, 2) NOT NULL COMMENT'小计（折扣后价格）',
`unit` varchar(50) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'单位',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='商机产品关系表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_business_status`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`type_id` bigint(20)  NOT NULL COMMENT'商机状态类别ID',
`name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT'标识',
`rate` varchar(20) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'赢单率',
`order_num` int NULL DEFAULT NULL COMMENT'排序',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47646 CHARACTER SET = utf8mb4 COMMENT ='商机状态' ROW_FORMAT = Dynamic;

INSERT INTO `crm_business_status` VALUES (47643, 12366,'验证客户','20', 1);
INSERT INTO `crm_business_status` VALUES (47644, 12366,'需求分析','30', 2);
INSERT INTO `crm_business_status` VALUES (47645, 12366,'方案/报价','80', 3);

CREATE TABLE IF NOT EXISTS  `crm_business_type`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT'标识',
 `dept_ids` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'部门ID',
 `create_user` bigint(20) NOT NULL COMMENT'创建人ID',
 `create_time` datetime NOT NULL COMMENT'创建时间',
 `update_time` datetime NULL DEFAULT NULL COMMENT'更新时间',
 `status` int NOT NULL DEFAULT 1 COMMENT'0禁用1启用2删除',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12367 CHARACTER SET = utf8 COMMENT ='商机状态组类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_business_type
-- ----------------------------
INSERT INTO `crm_business_type` VALUES (12366,'销售流程商机组','', 3,now(), NULL, 1);

CREATE TABLE IF NOT EXISTS  `crm_business_user_star`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`user_id` bigint(20) NOT NULL COMMENT'用户id',
`business_id` bigint(20) NOT NULL COMMENT'客户id',
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `user_id`(`user_id`, `business_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='用户商机标星关系表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS  `crm_contacts`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`name` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'联系人名称',
`next_time` datetime NULL DEFAULT NULL COMMENT'下次联系时间',
`mobile` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'手机',
`telephone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'电话',
`email` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'电子邮箱',
`post` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'职务',
`customer_id` bigint(20) NOT NULL COMMENT'客户ID',
`address` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'地址',
`remark` varchar(2048) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'备注',
`owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT'负责人ID',
`create_user` bigint(20) NULL DEFAULT NULL COMMENT'创建人ID',
`create_time` datetime NULL DEFAULT NULL COMMENT'创建时间',
`update_user` bigint(20) NULL DEFAULT NULL COMMENT'修改人ID',
`update_time` datetime NULL DEFAULT NULL COMMENT'更新时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT'批次',
`last_time` datetime NULL DEFAULT NULL COMMENT'最后跟进时间',
PRIMARY KEY (`id`) USING BTREE,
INDEX `owner_user_id`(`owner_user_id`) USING BTREE,
INDEX `customer_id`(`customer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COMMENT ='联系人表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_contacts_business`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `business_id` bigint(20) NOT NULL,
 `contacts_id` bigint(20) NOT NULL,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='商机联系人关联表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_contacts_data`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_id` bigint(20)  NOT NULL  COMMENT'字段id',
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
 `value` longtext CHARACTER SET utf8mb4  NULL,
 `create_time` datetime NOT NULL,
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `batch_id`(`batch_id`) USING BTREE,
 INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COMMENT ='联系人扩展字段数据表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_contacts_user_star`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`user_id` bigint(20) NOT NULL COMMENT'用户id',
`contacts_id` bigint(20) NOT NULL COMMENT'客户id',
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `user_id`(`user_id`, `contacts_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='用户联系人标星关系表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS  `crm_contract`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`name` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'合同名称',
`customer_id` bigint(20) NULL DEFAULT NULL COMMENT'客户ID',
`business_id` bigint(20) NULL DEFAULT NULL COMMENT'商机ID',
`check_status` int NOT NULL DEFAULT 0 COMMENT'0待审核、1通过、2拒绝、3审核中 4:撤回 5 未提交 6 创建 7 已删除 8 作废',
`examine_record_id` int NULL DEFAULT NULL COMMENT'审核记录ID',
`order_date` datetime NULL DEFAULT NULL COMMENT'下单日期',
`owner_user_id` bigint(20)  NULL DEFAULT NULL COMMENT'负责人ID',
`create_time` datetime NOT NULL COMMENT'创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT'更新时间',
`create_user` bigint(20)  NOT NULL COMMENT'创建人ID',
`update_user` bigint(20)  NOT NULL COMMENT'更新人ID',
`num` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'合同编号',
`start_time` datetime NULL DEFAULT NULL COMMENT'开始时间',
`end_time` datetime NULL DEFAULT NULL COMMENT'结束时间',
`money` decimal(18, 2) NULL DEFAULT NULL COMMENT'合同金额',
`discount_rate` decimal(10, 2) NULL DEFAULT NULL COMMENT'整单折扣',
`total_price` decimal(17, 2) NULL DEFAULT NULL COMMENT'产品总金额',
`types` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'合同类型',
`payment_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'付款方式',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT'批次 比如附件批次',
`ro_user_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'只读权限',
`rw_user_id` longtext CHARACTER SET utf8mb4  NULL COMMENT'读写权限',
`contacts_id` bigint(20) NULL DEFAULT NULL COMMENT'客户签约人（联系人id）',
`remark` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'备注',
`company_user_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT'公司签约人',
`last_time` datetime NULL DEFAULT NULL COMMENT'最后跟进时间',
`received_money` decimal(17, 2) NULL DEFAULT 0.00,
`unreceived_money` decimal(17, 2) NULL DEFAULT NULL,
`old_contract_id` bigint(20) NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='合同表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_contract_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_id` bigint(20) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT'字段名称',
  `value` longtext CHARACTER SET utf8mb4  NULL,
  `create_time` datetime NOT NULL,
  `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `batch_id`(`batch_id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='合同扩展字段数据表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS`crm_contract_product`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `contract_id` bigint(20) NOT NULL COMMENT'合同ID',
 `product_id` bigint(20) NOT NULL COMMENT'产品ID',
 `price` decimal(18, 2) NOT NULL COMMENT'产品单价',
 `sales_price` decimal(18, 2) NOT NULL COMMENT'销售价格',
 `num` decimal(10, 2) NOT NULL COMMENT'数量',
 `discount` decimal(18, 4) NOT NULL COMMENT'折扣',
 `subtotal` decimal(18, 2) NOT NULL COMMENT'小计（折扣后价格）',
 `unit` varchar(50) CHARACTER SET utf8mb4  NULL DEFAULT'' COMMENT'单位',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT ='合同产品关系表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS`crm_field`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_name` varchar(20) CHARACTER SET utf8mb4  NOT NULL COMMENT '自定义字段英文标识',
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL DEFAULT '' COMMENT '字段名称',
 `type` int NOT NULL DEFAULT 1 COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
 `label` int NOT NULL COMMENT '标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款 8 回款计划',
 `remark` varchar(60) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段说明',
 `input_tips` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '输入提示',
 `max_length` int NULL DEFAULT NULL COMMENT '最大长度',
 `default_value` varchar(5000) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '默认值',
 `is_unique` int NULL DEFAULT 0 COMMENT '是否唯一 1 是 0 否',
 `is_null` int NULL DEFAULT 0 COMMENT '是否必填 1 是 0 否',
 `sorting` int NULL DEFAULT 1 COMMENT '排序 从小到大',
 `options` longtext CHARACTER SET utf8mb4  NULL COMMENT '如果类型是选项，此处不能为空，多个选项以，隔开',
 `operating` int NULL DEFAULT 255 COMMENT '是否可以删除修改',
 `is_hidden` int NOT NULL DEFAULT 0 COMMENT '是否隐藏  0不隐藏 1隐藏',
 `field_type` int NOT NULL DEFAULT 0 COMMENT '字段来源  0.自定义 1.原始字段 2 原始字段但值存在扩展表中',
 `relevant` int NULL DEFAULT NULL COMMENT '只有线索需要，转换客户的自定义字段ID',
 `style_percent` int NULL DEFAULT 50 COMMENT '样式百分比%',
 `precisions` int NULL DEFAULT NULL COMMENT '精度，允许的最大小数位',
 `form_position` varchar(10) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '表单定位 坐标格式： 1,1',
 `max_num_restrict` varchar(20) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '限制的最大数值',
 `min_num_restrict` varchar(20) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '限制的最小数值',
 `form_assist_id` bigint(20) NULL DEFAULT NULL COMMENT '表单辅助id，前端生成',
 `create_user` bigint(20) NOT NULL COMMENT '创建人id',
 `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_timestamp COMMENT '最后修改时间',
 `update_user` bigint(20)DEFAULT NULL COMMENT '修改人',
 `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_timestamp COMMENT '最后修改时间',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `label`(`label`) USING BTREE,
 INDEX `update_time`(`update_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1101914 CHARACTER SET = utf8mb4 COMMENT = '自定义字段表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_field
-- ----------------------------
INSERT INTO `crm_field` VALUES (1101827, 'customer_name', '客户名称', 1, 2, NULL, NULL, 255, '', 1, 1, 0, NULL, 189, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101828, 'source', '客户来源', 3, 2, NULL, NULL, NULL, '', 0, 0, 1, '促销,搜索引擎,广告,转介绍,线上注册,线上询价,预约上门,陌拜,电话咨询,邮件咨询', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101829, 'mobile', '手机', 7, 2, NULL, NULL, 255, '', 0, 0, 2, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101830, 'telephone', '电话', 1, 2, NULL, NULL, 255, '', 0, 0, 3, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101831, 'website', '网址', 1, 2, NULL, NULL, 255, '', 0, 0, 4, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101832, 'industry', '客户行业', 3, 2, NULL, NULL, NULL, '', 0, 0, 5, 'IT,金融业,房地产,商业服务,运输/物流,生产,政府,文化传媒', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101833, 'level', '客户级别', 3, 2, NULL, NULL, NULL, '', 0, 0, 6, 'A（重点客户）,B（普通客户）,C（非优先客户）', 63, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101834, 'next_time', '下次联系时间', 13, 2, NULL, NULL, NULL, '', 0, 0, 7, NULL, 63, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101835, 'remark', '备注', 2, 2, NULL, NULL, 255, '', 0, 0, 8, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101836, 'email', '邮箱', 14, 2, NULL, NULL, 255, '', 0, 0, 4, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101837, 'leads_name', '线索名称', 1, 1, NULL, NULL, 255, '', 0, 1, 0, NULL, 189, 0,  1, 1101827, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101838, 'email', '邮箱', 14, 1, NULL, NULL, 255, '', 0, 0, 1, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101839, 'source', '线索来源', 3, 1, NULL, NULL, NULL, '', 0, 0, 2, '促销,搜索引擎,广告,转介绍,线上注册,线上询价,预约上门,陌拜,电话咨询,邮件咨询', 191, 0,  2, 1101828, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101840, 'mobile', '手机', 7, 1, NULL, NULL, 255, '', 0, 0, 3, NULL, 191, 0,  1, 1101829, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101841, 'telephone', '电话', 1, 1, NULL, NULL, 255, '', 0, 0, 4, NULL, 191, 0,  1, 1101830, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101842, 'address', '地址', 1, 1, NULL, NULL, 255, '', 0, 0, 5, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101843, 'industry', '客户行业', 3, 1, NULL, NULL, NULL, '', 0, 0, 6, 'IT,金融业,房地产,商业服务,运输/物流,生产,政府,文化传媒', 191, 0,  2, 1101832, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101844, 'level', '客户级别', 3, 1, NULL, NULL, NULL, '', 0, 0, 7, 'A（重点客户）,B（普通客户）,C（非优先客户）', 191, 0,  2, 1101833, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101845, 'next_time', '下次联系时间', 13, 1, NULL, NULL, NULL, '', 0, 0, 8, NULL, 63, 0,  1, 1101834, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101846, 'remark', '备注', 2, 1, NULL, NULL, 255, '', 0, 0, 9, NULL, 191, 0,  1, 1101835, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101847, 'name', '姓名', 1, 3, NULL, NULL, 255, '', 0, 1, 0, NULL, 181, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101848, 'customer_id', '客户名称', 15, 3, NULL, NULL, NULL, '', 0, 1, 1, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101849, 'mobile', '手机', 7, 3, NULL, NULL, 255, '', 0, 0, 2, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101850, 'telephone', '电话', 1, 3, NULL, NULL, 255, '', 0, 0, 3, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101851, 'email', '邮箱', 14, 3, NULL, NULL, 255, '', 0, 0, 4, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101852, 'post', '职务', 1, 3, NULL, NULL, 255, '', 0, 0, 5, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101853, 'policymakers', '是否关键决策人', 3, 3, NULL, NULL, NULL, '', 0, 0, 6, '是,否', 190, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101854, 'address', '地址', 1, 3, NULL, NULL, 255, '', 0, 0, 7, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101855, 'next_time', '下次联系时间', 13, 3, NULL, NULL, NULL, '', 0, 0, 8, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101856, 'remark', '备注', 2, 3, NULL, NULL, 255, '', 0, 0, 9, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101857, 'sex', '性别', 3, 3, NULL, NULL, NULL, '', 0, 0, 10, '男,女', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101858, 'name', '产品名称', 1, 4, NULL, NULL, 255, '', 0, 1, 0, NULL, 177, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101859, 'category_id', '产品类型', 19, 4, NULL, NULL, 255, '', 0, 1, 1, NULL, 1, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101860, 'unit', '产品单位', 3, 4, NULL, NULL, NULL, '', 0, 0, 2, '个,块,只,把,枚,瓶,盒,台,吨,千克,米,箱,套', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101861, 'num', '产品编码', 1, 4, NULL, NULL, 255, '', 1, 1, 3, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101862, 'price', '价格', 6, 4, NULL, NULL, 255, '', 0, 1, 4, NULL, 181, 0, 1, NULL, 50, 2, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101863, 'description', '产品描述', 1, 4, NULL, NULL, 255, '', 0, 0, 6, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101864, 'business_name', '商机名称', 1, 5, NULL, NULL, 255, '', 0, 1, 0, NULL, 181, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101865, 'customer_id', '客户名称', 15, 5, NULL, NULL, NULL, '', 0, 1, 1, NULL, 149, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101866, 'money', '商机金额', 6, 5, NULL, NULL, 255, '', 0, 0, 2, NULL, 189, 0,  1, NULL, 50, 2, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101867, 'deal_date', '预计成交日期', 13, 5, NULL, NULL, NULL, '', 0, 0, 3, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101868, 'remark', '备注', 2, 5, NULL, NULL, 255, '', 0, 0, 4, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101869, 'name', '合同名称', 1, 6, NULL, NULL, 255, '', 0, 1, 1, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101870, 'num', '合同编号', 1, 6, NULL, NULL, 255, '', 1, 1, 0, NULL, 177, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101871, 'customer_id', '客户名称', 15, 6, NULL, NULL, NULL, '', 0, 1, 2, NULL, 149, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101872, 'business_id', '商机名称', 16, 6, NULL, NULL, NULL, '', 0, 0, 3, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101873, 'money', '合同金额', 6, 6, NULL, NULL, 255, '', 0, 1, 4, NULL, 189, 0,  1, NULL, 50, 2, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101874, 'order_date', '下单时间', 4, 6, NULL, NULL, NULL, '', 0, 1, 5, NULL, 181, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101875, 'start_time', '合同开始时间', 4, 6, NULL, NULL, NULL, '', 0, 0, 6, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101876, 'end_time', '合同结束时间', 4, 6, NULL, NULL, NULL, '', 0, 0, 7, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101877, 'contacts_id', '客户签约人', 17, 6, NULL, NULL, NULL, '', 0, 0, 8, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101878, 'company_user_id', '公司签约人', 10, 6, NULL, NULL, NULL, '', 0, 0, 9, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101879, 'remark', '备注', 2, 6, NULL, NULL, 255, '', 0, 0, 10, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101880, 'flied_xucqai', '合同类型', 3, 6, NULL, NULL, 255, '', 0, 0, 11, '直销合同,代理合同,服务合同,快销合同', 255, 0,  0, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101881, 'number', '回款编号', 1, 7, NULL, NULL, 255, '', 1, 1, 0, NULL, 177, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101882, 'customer_id', '客户名称', 15, 7, NULL, NULL, NULL, '', 0, 1, 1, NULL, 149, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101883, 'contract_id', '合同编号', 20, 7, NULL, NULL, NULL, '', 0, 1, 2, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101884, 'receivables_plan_id', '期数', 21, 7, NULL, NULL, NULL, '', 0, 0, 3, NULL, 1, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101885, 'return_time', '回款日期', 4, 7, NULL, NULL, NULL, '', 0, 1, 4, NULL, 181, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101886, 'money', '回款金额', 6, 7, NULL, NULL, 255, '', 0, 1, 5, NULL, 181, 0, 1, NULL, 50, 2, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101887, 'return_type', '回款方式', 3, 7, NULL, NULL, NULL, '', 0, 0, 6, '支票,现金,邮政汇款,电汇,网上转账,支付宝,微信支付,其他', 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101888, 'remark', '备注', 2, 7, NULL, NULL, 255, '', 0, 0, 7, NULL, 191, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101889, 'customer_id', '客户名称', 15, 8, NULL, NULL, NULL, '', 0, 1, 1, NULL, 181, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101890, 'contract_id', '合同编号', 20, 8, NULL, NULL, 11, '', 0, 1, 2, NULL, 181, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101891, 'money', '计划回款金额', 6, 8, NULL, NULL, NULL, '', 0, 1, 3, NULL, 181, 0, 1, NULL, 50, 2, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101892, 'return_date', '计划回款日期', 4, 8, NULL, NULL, NULL, '', 0, 1, 4, NULL, 183, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101893, 'remind', '提前几天提醒', 5, 8, NULL, NULL, 11, '', 0, 0, 5, NULL, 1, 0, 1, NULL, 50, NULL, NULL, NULL,NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101894, 'remark', '备注', 2, 8, NULL, NULL, 1000, '', 0, 0, 6, NULL, 1, 0, 1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101895, 'visit_number', '回访编号', 1, 17, NULL, NULL, NULL, '', 1, 1, 0, NULL, 177, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101896, 'visit_time', '回访时间', 13, 17, NULL, NULL, NULL, '', 0, 1, 1, NULL, 181, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101897, 'owner_user_id', '回访人', 28, 17, NULL, NULL, NULL, '', 0, 1, 2, NULL, 149, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101898, 'return_visit_type', '回访形式', 3, 17, NULL, NULL, NULL, '', 0, 0, 3, '见面拜访,电话,短信,邮件,微信', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101899, 'customer_id', '客户名称', 15, 17, NULL, NULL, NULL, '', 0, 1, 4, NULL, 149, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101900, 'contacts_id', '联系人', 17, 17, NULL, NULL, NULL, '', 0, 0, 5, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101901, 'contract_id', '合同编号', 20, 17, NULL, NULL, NULL, '', 0, 1, 6, NULL, 159, 0,  1, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101902, 'satisficing', '客户满意度', 3, 17, NULL, NULL, NULL, '', 0, 0, 7, '很满意,满意,一般,不满意,很不满意', 191, 0,  2, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101903, 'flied_itvzix', '客户反馈', 2, 17, NULL, NULL, 1000, '', 0, 0, 8, NULL, 191, 0,  0, NULL, 50, NULL, NULL, NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101905, 'invoice_apply_number', '发票申请编号', 1, 18, NULL, NULL, NULL, '', 1, 1, 0, NULL, 176, 0, 1, NULL, 50, NULL, '0,0', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101906, 'customer_id', '客户名称', 15, 18, NULL, NULL, NULL, '', 0, 1, 1, NULL, 148, 0,  1, NULL, 50, NULL, '0,1', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101907, 'contract_id', '合同编号', 20, 18, NULL, NULL, NULL, '', 0, 1, 2, NULL, 148, 0, 1, NULL, 50, NULL, '1,0', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101908, 'contract_money', '合同金额', 6, 18, NULL, NULL, NULL, '', 0, 0, 3, NULL, 144, 0,  1, NULL, 50, 2, '1,1', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101909, 'invoice_money', '开票金额', 6, 18, NULL, NULL, NULL, '', 0, 1, 4, NULL, 148, 0,  1, NULL, 50, 2, '2,0', NULL, NULL,NULL, 1000,NULL,NOW(),NOW());
INSERT INTO `crm_field` VALUES (1101910, 'invoice_date', '开票日期', 13, 18, NULL, NULL, NULL, '', 0, 0, 5, NULL, 190, 0,  1, NULL, 50, NULL, '2,1', NULL, NULL,NULL, 1000,NULL,NOW(),NOW());
INSERT INTO `crm_field` VALUES (1101911, 'invoice_type', '开票类型', 3, 18, NULL, NULL, NULL, '', 0, 1, 6, '增值税专用发票,增值税普通发票,国税通用机打发票,地税通用机打发票,收据', 158, 0,  1, NULL, 50, NULL, '3,0', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101912, 'remark', '备注', 2, 18, NULL, NULL, 255, '', 0, 0, 7, NULL, 190, 0, 1, NULL, 50, NULL, '3,1', NULL, NULL,NULL,1000,NOW(),1000,NOW());
INSERT INTO `crm_field` VALUES (1101913, 'return_type', '回款方式', 3, 8, NULL, NULL, NULL, '', 0, 0, 6, '支票,现金,邮政汇款,电汇,网上转账,支付宝,微信支付,其他', 0, 0,  1, NULL, 50, NULL, NULL, NULL, NULL, NULL,1000,NOW(),1000,NOW());


CREATE TABLE IF NOT EXISTS`crm_field_config`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_name` varchar(20) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
  `field_type` int NOT NULL DEFAULT 1 COMMENT '字段类型 1 keyword 2 date 3 number 4 nested 5 datetime',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `label` int NOT NULL COMMENT 'label',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `field_name` (`field_name`, `label`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100294 CHARACTER SET = utf8mb4 COMMENT = '字段配置表' ROW_FORMAT = Dynamic;

INSERT INTO `crm_field_config` VALUES (100257, 'flied_dzmbcn', 4, '2020-08-03 18:46:43', 6);
INSERT INTO `crm_field_config` VALUES (100258, 'flied_ivcdhc', 4, '2020-08-03 18:47:30', 3);
INSERT INTO `crm_field_config` VALUES (100259, 'flied_pyrnyn', 1, '2020-08-03 19:12:42', 1);
INSERT INTO `crm_field_config` VALUES (100260, 'flied_dknbbe', 4, '2020-08-03 19:12:42', 1);
INSERT INTO `crm_field_config` VALUES (100261, 'flied_jhsivt', 1, '2020-08-03 19:15:51', 2);
INSERT INTO `crm_field_config` VALUES (100262, 'flied_bcethz', 3, '2020-08-04 17:17:04', 2);
INSERT INTO `crm_field_config` VALUES (100263, 'flied_jeqgso', 1, '2020-08-04 17:17:04', 2);
INSERT INTO `crm_field_config` VALUES (100264, 'flied_mjrdbe', 1, '2020-08-05 11:17:16', 2);
INSERT INTO `crm_field_config` VALUES (100265, 'flied_mtfnrf', 1, '2020-08-05 11:17:17', 2);
INSERT INTO `crm_field_config` VALUES (100266, 'flied_dlyjjb', 2, '2020-08-06 15:27:17', 1);
INSERT INTO `crm_field_config` VALUES (100267, 'flied_wxpcbx', 3, '2020-08-06 15:27:18', 1);
INSERT INTO `crm_field_config` VALUES (100268, 'flied_kjhmgc', 4, '2020-08-06 15:27:18', 2);
INSERT INTO `crm_field_config` VALUES (100269, 'flied_gdcrxx', 2, '2020-08-06 15:27:18', 2);
INSERT INTO `crm_field_config` VALUES (100270, 'flied_xfhonw', 1, '2020-08-06 15:27:18', 3);
INSERT INTO `crm_field_config` VALUES (100271, 'flied_fdncyr', 2, '2020-08-06 15:27:18', 3);
INSERT INTO `crm_field_config` VALUES (100272, 'flied_ijtnfc', 3, '2020-08-06 15:27:18', 3);
INSERT INTO `crm_field_config` VALUES (100273, 'flied_wuggiv', 1, '2020-08-06 15:27:18', 4);
INSERT INTO `crm_field_config` VALUES (100274, 'flied_mswlgq', 4, '2020-08-06 15:27:18', 4);
INSERT INTO `crm_field_config` VALUES (100275, 'flied_nmkltw', 2, '2020-08-06 15:27:18', 4);
INSERT INTO `crm_field_config` VALUES (100276, 'flied_jokwgt', 3, '2020-08-06 15:27:19', 4);
INSERT INTO `crm_field_config` VALUES (100277, 'flied_drfhhl', 1, '2020-08-06 15:27:19', 5);
INSERT INTO `crm_field_config` VALUES (100278, 'flied_uvqlpy', 4, '2020-08-06 15:27:19', 5);
INSERT INTO `crm_field_config` VALUES (100279, 'flied_temgvq', 2, '2020-08-06 15:27:19', 5);
INSERT INTO `crm_field_config` VALUES (100280, 'flied_lxujya', 3, '2020-08-06 15:27:19', 5);
INSERT INTO `crm_field_config` VALUES (100281, 'flied_kixhfg', 1, '2020-08-06 15:27:19', 6);
INSERT INTO `crm_field_config` VALUES (100282, 'flied_lzwnik', 2, '2020-08-06 15:27:19', 6);
INSERT INTO `crm_field_config` VALUES (100283, 'flied_dununn', 3, '2020-08-06 15:27:19', 6);
INSERT INTO `crm_field_config` VALUES (100284, 'flied_cqlfka', 1, '2020-08-06 15:27:19', 7);
INSERT INTO `crm_field_config` VALUES (100285, 'flied_ylgnov', 4, '2020-08-06 15:27:19', 7);
INSERT INTO `crm_field_config` VALUES (100286, 'flied_umnxvp', 2, '2020-08-06 15:27:19', 7);
INSERT INTO `crm_field_config` VALUES (100287, 'flied_mhbkno', 3, '2020-08-06 15:27:19', 7);
INSERT INTO `crm_field_config` VALUES (100288, 'flied_bthxmi', 1, '2020-08-06 15:27:20', 17);
INSERT INTO `crm_field_config` VALUES (100289, 'flied_xqimlp', 4, '2020-08-06 15:27:20', 17);
INSERT INTO `crm_field_config` VALUES (100290, 'flied_oojrlh', 2, '2020-08-06 15:27:20', 17);
INSERT INTO `crm_field_config` VALUES (100291, 'flied_tmboyd', 3, '2020-08-06 15:27:20', 17);
INSERT INTO `crm_field_config` VALUES (100292, 'flied_grasid', 1, '2020-08-12 18:14:51', 2);
INSERT INTO `crm_field_config` VALUES (100293, 'flied_ilvojx', 1, '2020-08-19 17:17:04', 1);


CREATE TABLE IF NOT EXISTS`crm_field_extend`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `parent_field_id`  bigint(20) NOT NULL COMMENT '对应主字段id',
  `field_name` varchar(20) CHARACTER SET utf8mb4  NOT NULL COMMENT '自定义字段英文标识',
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL DEFAULT '' COMMENT '字段名称',
  `type` int NOT NULL DEFAULT 1 COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
  `remark` varchar(60) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段说明',
  `input_tips` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '输入提示',
  `max_length` int NULL DEFAULT NULL COMMENT '最大长度',
  `default_value` varchar(5000) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '默认值',
  `is_unique` int NULL DEFAULT 0 COMMENT '是否唯一 1 是 0 否',
  `is_null` int NULL DEFAULT 0 COMMENT '是否必填 1 是 0 否',
  `sorting` int NULL DEFAULT 1 COMMENT '排序 从小到大',
  `options` longtext CHARACTER SET utf8mb4  NULL COMMENT '如果类型是选项，此处不能为空，多个选项以，隔开',
  `operating` int NULL DEFAULT 255 COMMENT '是否允许编辑',
  `is_hidden` int NOT NULL DEFAULT 0 COMMENT '是否隐藏  0不隐藏 1隐藏',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_timestamp COMMENT '最后修改时间',
  `field_type` int NOT NULL DEFAULT 0 COMMENT '字段来源  0.自定义 1.原始字段 2原始字段但值存在扩展表中',
  `style_percent` int NULL DEFAULT 50 COMMENT '样式百分比%',
  `precisions` int NULL DEFAULT NULL COMMENT '精度，允许的最大小数位',
  `form_position` varchar(10) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '表单定位 坐标格式： 1,1',
  `max_num_restrict` varchar(20) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '限制的最大数值',
  `min_num_restrict` varchar(20) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '限制的最小数值',
  `form_assist_id` int NULL DEFAULT NULL COMMENT '表单辅助id，前端生成',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `update_time` (`update_time`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12231 CHARACTER SET = utf8mb4 COMMENT = '自定义字段表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_field_sort`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`field_id` bigint(20) NULL DEFAULT NULL COMMENT '字段ID',
`field_name` varchar(50) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段名称',
`name` varchar(50) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
`label` int NOT NULL COMMENT '标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划',
`type` int NULL DEFAULT NULL COMMENT '字段类型',
`style` int NULL DEFAULT NULL COMMENT '字段宽度',
`sort` int NOT NULL DEFAULT 0 COMMENT '字段排序',
`user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户id',
`is_hide` int NOT NULL DEFAULT 1 COMMENT '是否隐藏 0、不隐藏 1、隐藏',
PRIMARY KEY (`id`) USING BTREE,
UNIQUE INDEX `label`(`user_id`, `field_name`, `label`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1961 CHARACTER SET = utf8mb4 COMMENT = '字段排序表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_instrument_sort`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `user_id` bigint(20) NOT NULL COMMENT '用户id',
 `model_id` int NOT NULL COMMENT '模块id 1、合同金额目标及完成情况 2、数据汇总 3、回款金额目标及完成情况 4、业绩指标完成率 5、销售漏斗 6、遗忘提醒 7、排行榜',
 `list` int NOT NULL COMMENT '列 1左侧 2右侧',
 `sort` int NOT NULL COMMENT '排序',
 `is_hidden` int NOT NULL DEFAULT 0 COMMENT '是否隐藏 0显示 1隐藏',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '仪表盘排序表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_invoice`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`invoice_apply_number` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '发票申请编号',
`customer_id` bigint(20) NOT NULL COMMENT '客户id',
`contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同id',
`invoice_money` decimal(10, 2) NOT NULL COMMENT '开票金额',
`invoice_date` date NULL DEFAULT NULL COMMENT '开票日期',
`invoice_type` int NOT NULL COMMENT '开票类型',
`remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
`title_type` int NULL DEFAULT NULL COMMENT '抬头类型 1单位 2个人',
`invoice_title` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开票抬头',
`tax_number` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '纳税识别号',
`deposit_bank` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开户行',
`deposit_account` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开户账户',
`deposit_address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开票地址',
`telephone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '电话',
`contacts_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '联系人名称',
`contacts_mobile` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '联系方式',
`contacts_address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '邮寄地址',
`examine_record_id` bigint(20) NULL DEFAULT NULL COMMENT '审批记录id',
`check_status` int NULL DEFAULT NULL COMMENT '审核状态 0待审核、1通过、2拒绝、3审核中、4撤回',
`owner_user_id` bigint NOT NULL COMMENT '负责人id',
`invoice_number` varchar(32) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '发票号码',
`real_invoice_date` date NULL DEFAULT NULL COMMENT '实际开票日期',
`logistics_number` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '物流单号',
`invoice_status` int NOT NULL DEFAULT 0 COMMENT '开票状态 0 未开票， 1 已开票',
`create_user` bigint(20) NOT NULL COMMENT '创建人id',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT '批次id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '发票表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_invoice_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_id` bigint(20) NOT NULL  COMMENT'fieldId',
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
  `value` longtext CHARACTER SET utf8mb4  NULL,
  `create_time` datetime NOT NULL,
  `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `batch_id`(`batch_id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2250 CHARACTER SET = utf8mb4 COMMENT = '发票扩展字段数据表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_invoice_info`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`customer_id` bigint(20)  NOT NULL COMMENT '客户id',
`title_type` int NULL DEFAULT NULL COMMENT '抬头类型 1单位 2个人',
`invoice_title` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开票抬头',
`tax_number` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '纳税识别号',
`deposit_bank` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开户行',
`deposit_account` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开户账户',
`deposit_address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '开票地址',
`telephone` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '电话',
`remark` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
`create_user`  bigint(20)  NOT NULL COMMENT '创建人id',
`create_time` datetime NOT NULL COMMENT '创建时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '发票详情表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_leads`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `is_transform` int NULL DEFAULT 0 COMMENT '1已转化 0 未转化',
 `followup` int NULL DEFAULT NULL COMMENT '跟进状态 0未跟进1已跟进',
 `leads_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '线索名称',
 `customer_id`  bigint(20)  NULL DEFAULT NULL COMMENT '客户id',
 `next_time` datetime NULL DEFAULT NULL COMMENT '下次联系时间',
 `telephone` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '电话',
 `mobile` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '手机号',
 `email` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '邮箱',
 `address` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '地址',
 `remark` varchar(800) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '备注',
 `owner_user_id`  bigint(20)  NULL DEFAULT NULL COMMENT '负责人ID',
 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
 `update_user` bigint(20)DEFAULT NULL COMMENT '修改人',
 `create_user` bigint(20) NULL DEFAULT NULL COMMENT'创建人ID',
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT '批次 比如附件批次',
 `is_receive` int NULL DEFAULT NULL COMMENT '1 分配',
 `last_time` datetime NULL DEFAULT NULL COMMENT '最后跟进时间',
 `last_content` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '最后一条跟进记录',
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `owner_user_id`(`owner_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COMMENT = '线索表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_leads_data`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_id` bigint(20) NOT NULL  COMMENT'fieldId',
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
 `value` longtext CHARACTER SET utf8mb4  NULL,
 `create_time` datetime NOT NULL,
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `batch_id`(`batch_id`) USING BTREE,
 INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COMMENT = '线索自定义字段存值表' ROW_FORMAT = Dynamic;


CREATE TABLE IF NOT EXISTS `crm_leads_user_star`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `leads_id` bigint(20) NOT NULL COMMENT '线索id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_id`(`user_id`, `leads_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '用户线索标星关系表 ' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_marketing`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`marketing_name` varchar(30) CHARACTER SET utf8mb4  NOT NULL COMMENT '营销名称',
`crm_type` int NOT NULL DEFAULT 1 COMMENT '1线索  2客户',
`end_time` datetime NOT NULL COMMENT '截止时间',
`relation_user_id` varchar(200) CHARACTER SET utf8mb4  NOT NULL COMMENT '关联人员ID',
`create_user` bigint NOT NULL COMMENT '创建人ID',
`status` int NOT NULL DEFAULT 1 COMMENT '1启用  0禁用',
`second` int NOT NULL DEFAULT 0 COMMENT '每个客户只能填写次数 0 1',
`field_data_id` text CHARACTER SET utf8mb4  NOT NULL COMMENT '营销内容填写字段',
`browse` int NULL DEFAULT 0 COMMENT '浏览数',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NOT NULL COMMENT '修改时间',
`start_time` datetime NULL DEFAULT NULL COMMENT '开始时间',
`share_num` int NULL DEFAULT 0 COMMENT '分享数',
`submit_num` int NULL DEFAULT 0 COMMENT '提交数',
`synopsis` longtext CHARACTER SET utf8mb4  NULL COMMENT '简介',
`main_file_ids` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '首图id',
`detail_file_ids` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
`address` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '活动地址',
`marketing_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '活动类型',
`marketing_money` decimal(11, 2) NULL DEFAULT NULL COMMENT '活动金额',
`relation_dept_id` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '关联部门id',
PRIMARY KEY (`id`) USING BTREE,
INDEX `status`(`status`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '营销表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_marketing_field`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '自定义字段英文标识',
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL DEFAULT '' COMMENT '字段名称',
  `type` int NOT NULL DEFAULT 1 COMMENT '字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划',
  `remark` varchar(60) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段说明',
  `input_tips` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '输入提示',
  `max_length` int NULL DEFAULT NULL COMMENT '最大长度',
  `default_value` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT '' COMMENT '默认值',
  `is_unique` int NULL DEFAULT 0 COMMENT '是否唯一 1 是 0 否',
  `is_null` int NULL DEFAULT 0 COMMENT '是否必填 1 是 0 否',
  `sorting` int NULL DEFAULT 1 COMMENT '排序 从小到大',
  `options` longtext CHARACTER SET utf8mb4  NULL COMMENT '如果类型是选项，此处不能为空，多个选项以，隔开',
  `operating` int NULL DEFAULT 0 COMMENT '是否可以删除修改 0 改删 1 改 2 删 3 无',
  `is_hidden` int NOT NULL DEFAULT 0 COMMENT '是否隐藏  0不隐藏 1隐藏',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_timestamp COMMENT '最后修改时间',
  `form_id` bigint(20) NULL DEFAULT NULL COMMENT '表单Id',
  `field_type` int NOT NULL DEFAULT 0 COMMENT '字段来源  0.自定义 1.原始字段 2原始字段但值存在扩展表中',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb4 COMMENT = '市场活动字段表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_marketing_form`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`title` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '名称',
`remarks` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '描述',
`create_user` bigint NULL DEFAULT NULL COMMENT '创建人ID',
`status` int NULL DEFAULT 1 COMMENT '1启用，0禁用',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`is_deleted` int NULL DEFAULT 0 COMMENT '1已删除',
`delete_time` datetime NULL DEFAULT NULL COMMENT '删除时间',
`delete_user_id` bigint NULL DEFAULT NULL COMMENT '删除人ID',
`update_user` bigint NULL DEFAULT NULL COMMENT '创建人ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COMMENT = '市场活动表单信息' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_marketing_info`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `marketing_id` bigint(20)  NOT NULL COMMENT '关联ID',
 `status` int NOT NULL DEFAULT 0 COMMENT '0未同步  1同步成功  2同步失败',
 `field_info` text CHARACTER SET utf8mb4  NOT NULL COMMENT '营销内容填写字段内容',
 `device` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT '设备号',
 `owner_user_id` bigint NOT NULL COMMENT '关联ID',
 `create_time` datetime NOT NULL COMMENT '创建时间',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '营销数据表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_number_setting`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `pid` bigint(20) NOT NULL COMMENT '父级设置id',
 `sort` int NOT NULL COMMENT '编号顺序',
 `type` int NOT NULL COMMENT '编号类型 1文本 2日期 3数字',
 `value` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '文本内容或日期格式或起始编号',
 `increase_number` int NULL DEFAULT NULL COMMENT '递增数',
 `reset_type` int NULL DEFAULT NULL COMMENT '重新编号周期 1每天 2每月 3每年 4从不',
 `last_number` int NULL DEFAULT NULL COMMENT '上次生成的编号',
 `last_date` date NULL DEFAULT NULL COMMENT '上次生成的时间',
 `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
 `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人id',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '系统自动生成编号设置表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_owner_record`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `type_id` bigint(20) NOT NULL COMMENT '对象id',
 `type` int NOT NULL COMMENT '对象类型',
 `pre_owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT '上一负责人',
 `post_owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT '接手负责人',
 `create_time` datetime NOT NULL COMMENT '创建时间',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COMMENT = '负责人变更记录表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_print_record`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `crm_type` int NOT NULL,
  `type_id` int NOT NULL,
  `template_id` bigint(20) NOT NULL COMMENT '模板id',
  `record_content` longtext CHARACTER SET utf8mb4  NULL COMMENT '打印记录',
  `create_user` bigint NOT NULL COMMENT '创建人id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '打印记录表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_print_template`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`template_name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '模板名称',
`type` int NOT NULL COMMENT '关联对象',
`content` longtext CHARACTER SET utf8mb4  NULL COMMENT '模板',
`create_user` bigint(20) NOT NULL COMMENT '创建人id',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COMMENT = '打印模板表' ROW_FORMAT = Dynamic;

INSERT INTO `crm_print_template` VALUES (20, '合同条款打印模板', 6, '<p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>***有限公司</span></p><p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>销售合同</span></p><p style=\`text-align: right;\`><span style=\`font-size: 14px; font-family: simsun, serif; color: #525151;\`>合同编号：<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.num\`>{合同编号}</span></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>甲方：<span class=\`wk-print-tag-wukong wk-tiny-color--customer\` contenteditable=\`true\` data-wk-tag=\`customer.customer_name\`>{客户名称}</span><u></u></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>乙方：郑州卡卡罗特软件科技有限公司</span></p><p style=\`line-height: 1.75;\`>&nbsp;</p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>甲乙双方本着相互信任，真诚合作的原则，经双方友好协商，就乙方为甲方提供特定服务达成一致意见，特签订本合同。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`><strong>一、服务内容</strong></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>1、乙方同意向甲方提供的特定服务。服务的内容的标准见附件A。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>2、如果乙方在工作中因自身过错而发生任何错误或遗漏，乙方应无条件更正，而不另外收费，并对因此而对甲方造成的损失承担赔偿责任，赔偿以附件A所载明的该项服务内容对应之服务费为限。若因甲方原因造成工作的延误，将由甲方承担相应的损失。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>3、乙方的服务承诺：</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>&nbsp; &nbsp; 1）乙方接到甲方通过电话、信函传真、电子邮件、网上提交等方式提出关于附件A所列服务的请求后，在两个有效工作日内给予响应并提供服务。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>&nbsp; &nbsp; 2）乙方提供给甲方的服务，必须按照合同附件A规定的标准进行。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>4、产品明细：</span></p><table style=\`border-collapse: collapse; width: 100%; float: right;\` border=\`1\` data-wk-table-tag=\`table\`><tbody><tr data-wk-table-tr-tag=\`header\`><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品名称</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品类别</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>单位</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>价格</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>售价</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>数量</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>折扣</span></strong></td><td style=\`background-color: #ffffff;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>合计</span></strong></td></tr><tr data-wk-table-tr-tag=\`value\`><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品名称}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.category_name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品类别}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.单位\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{单位}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{价格}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{售价}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_num\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{数量}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.discount\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{折扣}</span></span></td><td data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.subtotal\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合计}</span></span></td></tr></tbody></table><p style=\`line-height: 1.75;\`><span style=\`font-family: simsun, serif;\`><span style=\`font-size: 14px;\`>整单折扣：<span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-tag=\`contract.discount_rate\`>{整单折扣}</span></span><span style=\`font-size: 14px;\`>&nbsp; &nbsp;产品总金额（元）：<span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-tag=\`contract.total_price\`>{产品总金额}</span></span></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`><strong>二、服务费的支付</strong></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>1、服务费总金额为<u>&nbsp; &nbsp;&nbsp;<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.money\`>{合同金额}</span>&nbsp; &nbsp;</u>元人民币(人民币大写：<u>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</u>元整)。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>2、本费用结构仅限於附件A中列明的工作。如果甲方要求扩大项目范围，或因甲方改变已经议定的项目内容导致乙方需重复进行项目步骤，乙方将需要重新评估上述费用结构。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>3、甲乙双方一致同意项目服务费按一次性以人民币形式支付。服务完成后，甲方将在验收确认服务完成合格，并且乙方发出该阶段工作的费用账单及正式有效的税务发票后3个工作日内，向乙方支付约定的费用。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>4、有关发票方面的任何问题，甲方应在收到发票后及时书面通知乙方，便乙方及时作出解释或解决问题，以使甲方能按时付款。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>5、乙方将自行承担项目实施范围内合理的差旅费用。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>6、乙方同意免除项目杂费。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>7、本协议有效期为：&nbsp; <u>&nbsp; &nbsp;<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.start_time\`>{合同开始时间}</span></u><u>&nbsp; &nbsp; </u>&nbsp; 起&nbsp; <u>&nbsp; &nbsp;&nbsp;<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.end_time\`>{合同结束时间}</span></u><u>&nbsp; &nbsp; </u>&nbsp;止</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`><strong>三、服务的变更</strong></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>甲方可以提前个工作日以书面形式要求变更或增加所提供的服务。该等变更最终应由双方互相商定认可，其中包括与该等变更有关的任何费用调整。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`><strong>四、争议处理</strong></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>甲乙双方如对协议条款规定的理解有异议，或者对与协议有关的事项发生争议，双方应本着友好合作的精神进行协商。协商不能解决的，任何一方可向仲裁委员会提起仲裁。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`><strong>五、其他</strong></span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>1、本合同中所用的标题仅为方便而设，而不影响对本合同的解释。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>2、附件A是本合同不可分割的组成部分，与本合同具有同等法律效力。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>3、本合同未尽事宜，由甲乙双方协商后产生书面文件，作为本合同的补充条款，具备与本合同同等法律效力。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>4、对本合同内容的任何修改和变更需要，用书面形式，并经双方确认后生效。</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>(以下无正文)</span></p><p style=\`line-height: 1.75;\`>&nbsp;</p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>甲方（签章）&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;乙方（签章）</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>代表签字：&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;代表签字：</span></p><p style=\`line-height: 1.75;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>日期：&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;日期：</span></p>', 0, '2020-08-22 11:40:42', NULL);
INSERT INTO `crm_print_template` VALUES (21, '合同订单打印模板', 6, '<p style=\`text-align: center; line-height: 2;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>合同订单</span></p><p style=\`line-height: 2; text-align: right;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>合同编号：<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.num\`>{合同编号}</span></span></p><table style=\`border-collapse: collapse; width: 102.185%; height: 147px;\` border=\`1\`><tbody><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>合同名称：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合同名称}</span></span><span style=\`font-size: 14px; font-family: simsun, serif;\`>&nbsp;</span></td><td style=\`width: 52.3571%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>客户名称：</span><span class=\`wk-print-tag-wukong wk-tiny-color--customer\` contenteditable=\`true\` data-wk-tag=\`customer.customer_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{客户名称}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>合同总金额：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.money\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合同金额}</span></span></td><td style=\`width: 52.3571%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>负责人：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.owner_user_name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{负责人}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>相关商机：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.business_name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{商机名称}</span></span><span style=\`font-size: 14px; font-family: simsun, serif;\`>&nbsp;</span></td><td style=\`width: 52.3571%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>签订时间：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.order_date\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{下单时间}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>开始时间：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.start_time\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合同开始时间}</span></span></td><td style=\`width: 52.3571%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>结束时间：</span><span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`true\` data-wk-tag=\`contract.end_time\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{合同结束时间}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>备注：<span class=\`wk-print-tag-wukong wk-tiny-color--contract\` contenteditable=\`false\` data-wk-tag=\`contract.remark\`>{备注}</span></span></td><td style=\`width: 52.3571%; height: 21px;\`>&nbsp;</td></tr></tbody></table><p style=\`line-height: 2;\`>&nbsp;</p><p style=\`line-height: 2;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品明细：</span></p><table style=\`border-collapse: collapse; width: 102.185%; height: 60px; line-height: 2;\` border=\`1\` data-wk-table-tag=\`table\`><tbody><tr data-wk-table-tr-tag=\`header\`><td style=\`width: 16.2207%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品名称</span></strong></td><td style=\`width: 16.2207%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品类别</span></strong></td><td style=\`width: 9.53177%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>单位</span></strong></td><td style=\`width: 13.8796%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>标准价格</span></strong></td><td style=\`width: 13.8796%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>销售单价</span></strong></td><td style=\`width: 9.699%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>数量</span></strong></td><td style=\`width: 9.699%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>折扣</span></strong></td><td style=\`width: 9.69447%;\` data-wk-table-td-tag=\`name\`><strong><span style=\`font-size: 14px; font-family: simsun, serif;\`>合计</span></strong></td></tr><tr data-wk-table-tr-tag=\`value\`><td style=\`width: 16.2207%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品名称}</span></span></td><td style=\`width: 16.2207%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.category_name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品类别}</span></span></td><td style=\`width: 9.53177%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.单位\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{单位}</span></span></td><td style=\`width: 13.8796%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{价格}</span></span></td><td style=\`width: 13.8796%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{售价}</span></span></td><td style=\`width: 9.699%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_num\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{数量}</span></span></td><td style=\`width: 9.699%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.discount\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{折扣}</span></span></td><td style=\`width: 9.69447%;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.subtotal\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合计}</span></span></td></tr></tbody></table><p style=\`text-align: right; line-height: 2;\`><span style=\`font-family: simsun, serif;\`>产品总金额：</span><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-tag=\`contract.total_price\`><span style=\`font-family: simsun, serif;\`>{产品总金额}</span></span></p><p>&nbsp;</p><p>&nbsp;</p>', 0, '2020-08-22 11:40:42', NULL);
INSERT INTO `crm_print_template` VALUES (22, '商机打印模板', 5, '<p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>***有限公司</span></p><p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>商机</span></p><table style=\`border-collapse: collapse; width: 100.337%; height: 138px;\` border=\`1\`><tbody><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>商机名称：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.business_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{商机名称}</span></span></td><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>客户名称：</span><span class=\`wk-print-tag-wukong wk-tiny-color--customer\` contenteditable=\`true\` data-wk-tag=\`customer.customer_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{客户名称}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>商机状态组：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.type_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{商机状态组}</span></span></td><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>商机阶段：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.status_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{商机阶段}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>预计成交时间：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.deal_date\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{预计成交日期}</span></span></td><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>商机金额（元）：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.money\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{商机金额}</span></span></td></tr><tr style=\`height: 21px;\`><td style=\`width: 50%; height: 21px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>负责人：</span><span class=\`wk-print-tag-wukong wk-tiny-color--business\` contenteditable=\`true\` data-wk-tag=\`business.owner_user_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{负责人}</span></span></td><td style=\`width: 50%; height: 21px;\`>&nbsp;</td></tr></tbody></table><p style=\`text-align: left; line-height: 2;\`>&nbsp;</p><p style=\`text-align: left; line-height: 2;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>产品明细：</span></p><table style=\`border-collapse: collapse; width: 100%; height: 65px; line-height: 2;\` border=\`1\` data-wk-table-tag=\`table\`><tbody><tr style=\`height: 31px;\` data-wk-table-tr-tag=\`header\`><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>产品名称</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>产品类型</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>单位</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>价格</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>售价</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>数量</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>折扣</span></strong></span></td><td style=\`height: 31px;\` data-wk-table-td-tag=\`name\`><span style=\`font-size: 14px;\`><strong><span style=\`font-family: simsun, serif;\`>合计</span></strong></span></td></tr><tr style=\`height: 38px;\` data-wk-table-tr-tag=\`value\`><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.name\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品名称}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.category_id\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品类型}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.单位\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{单位}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{价格}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{售价}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.sales_num\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{数量}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.discount\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{折扣}</span></span></td><td style=\`height: 34px;\` data-wk-table-td-tag=\`value\`><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-table-value-tag=\`product.subtotal\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{合计}</span></span></td></tr></tbody></table><p style=\`text-align: left; line-height: 2;\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>整单折扣：</span><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-tag=\`business.discount_rate\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{整单折扣}</span></span><span style=\`font-size: 14px; font-family: simsun, serif;\`>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;产品总金额（元）：</span><span class=\`wk-print-tag-wukong wk-tiny-color--product\` contenteditable=\`true\` data-wk-tag=\`business.total_price\`><span style=\`font-size: 14px; font-family: simsun, serif;\`>{产品总金额}</span></span></p>', 0, '2020-08-22 11:40:42', NULL);
INSERT INTO `crm_print_template` VALUES (23, '回款打印模板', 7, '<p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>***有限公司</span></p><p style=\`text-align: center; line-height: 1; margin-bottom: 15px;\`><span style=\`font-size: 36px; font-family: simsun, serif;\`>回款单</span></p><table style=\`border-collapse: collapse; width: 100.842%; height: 146px;\` border=\`1\`><tbody><tr style=\`height: 18px;\`><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>客户名称：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.customer_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{客户名称}</span></span></td><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>回款编号：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.number\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{回款编号}</span></span></td></tr><tr style=\`height: 18px;\`><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>回款日期：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.return_time\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{回款日期}</span></span></td><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>回款方式：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.return_type\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{回款方式}</span></span></td></tr><tr style=\`height: 18px;\`><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>回款期数：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.plan_num\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{期数}</span></span></td><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>回款金额（元）：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.money\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{回款金额}</span></span></td></tr><tr style=\`height: 18px;\`><td style=\`width: 50%; height: 18px;\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>负责人：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.owner_user_name\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{负责人}</span></span></td><td style=\`width: 50%; height: 18px;\`>&nbsp;</td></tr><tr style=\`height: 18px;\`><td style=\`width: 50%; height: 18px;\` colspan=\`2\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>备注：</span><span class=\`wk-print-tag-wukong wk-tiny-color--receivables\` contenteditable=\`true\` data-wk-tag=\`receivables.remark\`><span style=\`font-family: simsun, serif; font-size: 14px;\`>{备注}</span></span></td></tr></tbody></table>', 0, '2020-08-22 11:40:42', NULL);

CREATE TABLE IF NOT EXISTS`crm_product`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '产品名称',
`num` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '产品编码',
`unit` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '单位',
`price` decimal(18, 2) NULL DEFAULT 0.00 COMMENT '价格',
`status` int NULL DEFAULT NULL COMMENT '状态 1 上架 0 下架 3 删除',
`category_id` int NULL DEFAULT NULL COMMENT '产品分类ID',
`description` text CHARACTER SET utf8mb4  NULL COMMENT '产品描述',
`create_user` bigint NOT NULL COMMENT '创建人ID',
`owner_user_id` bigint NULL DEFAULT NULL COMMENT '负责人ID',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT '批次',
`old_product_id` int NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '产品表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_product_category`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `name` varchar(200) CHARACTER SET utf8mb4  NULL DEFAULT '',
  `pid` bigint(20) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14768 CHARACTER SET = utf8mb4 COMMENT = '产品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of crm_product_category
-- ----------------------------
INSERT INTO `crm_product_category` VALUES (14767, '默认', 0);

CREATE TABLE IF NOT EXISTS`crm_product_data`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_id` bigint(20)  NOT NULL,
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
 `value` longtext CHARACTER SET utf8mb4  NULL,
 `create_time` datetime NOT NULL,
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `batch_id`(`batch_id`) USING BTREE,
 INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '产品自定义字段存值表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_product_detail_img`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`product_id` bigint(20)  NULL DEFAULT NULL COMMENT '产品id',
`remarks` longtext CHARACTER SET utf8mb4  NULL,
`main_file_ids` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '主图',
`detail_file_ids` varchar(1024) CHARACTER SET utf8mb4  NULL DEFAULT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '产品详情图片' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_product_user`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `product_ids` varchar(255) CHARACTER SET utf8mb4  NOT NULL,
 `user_id` bigint NOT NULL,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '产品员工小程序显示关联表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_receivables`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`number` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '回款编号',
`receivables_plan_id` int NULL DEFAULT NULL COMMENT '回款计划ID',
`customer_id` int NULL DEFAULT NULL COMMENT '客户ID',
`contract_id` int NULL DEFAULT NULL COMMENT '合同ID',
`check_status` int NULL DEFAULT NULL COMMENT '0待审核、1通过、2拒绝、3审核中 4:撤回 5 未提交',
`examine_record_id` int NULL DEFAULT NULL COMMENT '审核记录ID',
`return_time` date NULL DEFAULT NULL COMMENT '回款日期',
`return_type` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '回款方式',
`money` decimal(17, 2) NULL DEFAULT NULL COMMENT '回款金额',
`remark` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
`create_user` bigint NOT NULL COMMENT '创建人ID',
`owner_user_id` bigint NULL DEFAULT NULL COMMENT '负责人ID',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`remarks` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT '批次',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '回款表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS`crm_receivables_data`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `field_id` bigint(20) NOT NULL COMMENT'字段Id',
 `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
 `value` longtext CHARACTER SET utf8mb4  NULL,
 `create_time` datetime NOT NULL,
 `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
 PRIMARY KEY (`id`) USING BTREE,
 INDEX `batch_id`(`batch_id`) USING BTREE,
 INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '回款自定义字段存值表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_receivables_plan`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`num` varchar(100) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '期数',
`receivables_id` bigint(20) NULL DEFAULT NULL COMMENT '回款ID',
`status` int NULL DEFAULT NULL COMMENT '1完成 0 未完成',
`money` decimal(18, 2) NULL DEFAULT NULL COMMENT '计划回款金额',
`return_date` datetime NULL DEFAULT NULL COMMENT '计划回款日期',
`return_type` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '计划回款方式',
`remind` int NULL DEFAULT NULL COMMENT '提前几天提醒',
`remind_date` datetime NULL DEFAULT NULL COMMENT '提醒日期',
`remark` varchar(500) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '备注',
`create_user` bigint(20) NOT NULL COMMENT '创建人ID',
`owner_user_id` bigint(20) NULL DEFAULT NULL COMMENT '负责人ID',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '附件批次ID',
`real_received_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '实际回款金额',
`real_return_date` datetime NULL DEFAULT NULL COMMENT '实际回款日期',
`unreceived_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '未回款金额',
`received_status` int NULL DEFAULT 0 COMMENT '回款状态 0 待回款 1 回款完成 2 部分回款 3 作废 4 逾期 5 待生效',
`contract_id` bigint(20) NOT NULL COMMENT '合同ID',
`customer_id` bigint(20) NULL DEFAULT NULL COMMENT '客户ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '回款计划表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_receivables_plan_data`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `field_id` bigint(20) NOT NULL COMMENT'字段Id',
  `name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
  `value` longtext CHARACTER SET utf8mb4  NULL,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `batch_id`(`batch_id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COMMENT = '回款计划自定义字段存值表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_return_visit`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`visit_number` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '回访编号',
`visit_time` datetime NULL DEFAULT NULL COMMENT '回访时间',
`owner_user_id` bigint NULL DEFAULT NULL COMMENT '回访人id',
`customer_id` bigint(20)  NULL DEFAULT NULL COMMENT '客户id',
`contract_id` bigint(20)  NULL DEFAULT NULL COMMENT '合同id',
`contacts_id` bigint(20)  NULL DEFAULT NULL COMMENT '联系人id',
`create_user` bigint(20)  NULL DEFAULT NULL COMMENT '创建人id',
`create_time` datetime NOT NULL COMMENT '创建时间',
`update_time` datetime NOT NULL COMMENT '更新时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL COMMENT '批次id',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '回访表\r\n' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_return_visit_data`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`field_id` bigint(20) NOT NULL COMMENT'字段Id',
`name` varchar(255) CHARACTER SET utf8mb4  NOT NULL COMMENT '字段名称',
`value` longtext CHARACTER SET utf8mb4  NULL,
`create_time` datetime NOT NULL  COMMENT '创建时间',
`batch_id` varchar(32) CHARACTER SET utf8mb4  NOT NULL,
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '回访扩展数据表' ROW_FORMAT = Dynamic;
CREATE TABLE IF NOT EXISTS `crm_role_field`  (
 `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
 `role_id` bigint(20) NOT NULL COMMENT '角色id',
 `label` int NOT NULL COMMENT 'crm模块',
 `field_id` bigint(20) NULL DEFAULT NULL COMMENT '字段id',
 `field_name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段标识',
 `name` varchar(255) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '字段名称',
 `auth_level` int NOT NULL COMMENT '权限 1不可编辑不可查看 2可查看不可编辑 3可编辑可查看',
 `operate_type` int NOT NULL COMMENT '操作权限 1都可以设置 2只有查看权限可设置 3只有编辑权限可设置 4都不能设置',
 `mask_type` int NULL DEFAULT 0 COMMENT '掩码类型 0 都不隐藏 1 列表隐藏详情不隐藏 2 都隐藏',
 `field_type` int NULL DEFAULT NULL COMMENT '  0自定义字段 1原始字段 2原始字段但值在data表 3关联表的字段 4系统字段',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '角色字段授权表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_scene`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
  `type` int NOT NULL COMMENT '分类',
  `name` varchar(50) CHARACTER SET utf8mb4  NOT NULL COMMENT '场景名称',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `sort` int NOT NULL COMMENT '排序ID',
  `data` text CHARACTER SET utf8mb4  NOT NULL COMMENT '属性值',
  `is_hide` int NOT NULL COMMENT '1隐藏',
  `is_system` int NOT NULL COMMENT '1系统0自定义',
  `by_data` varchar(50) CHARACTER SET utf8mb4  NULL DEFAULT NULL COMMENT '系统参数',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 621 CHARACTER SET = utf8mb4 COMMENT = '场景' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS `crm_scene_default`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`type` int NOT NULL COMMENT '类型',
`user_id` bigint(20) NOT NULL COMMENT '人员ID',
`scene_id` bigint(20) NOT NULL COMMENT '场景ID',
PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COMMENT = '场景默认关系表' ROW_FORMAT = Dynamic;

CREATE TABLE IF NOT EXISTS  `crm_team_members`  (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT'主键id',
`type` int NOT NULL COMMENT '类型，同crm类型',
`type_id` bigint(20) NOT NULL COMMENT '对应类型主键ID',
`user_id` bigint(20) NOT NULL COMMENT '用户ID',
`power` int NULL DEFAULT NULL COMMENT '1 只读 2 读写 3 负责人',
`create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
`expires_time` datetime NULL DEFAULT NULL COMMENT '过期时间',
PRIMARY KEY (`id`) USING BTREE,
INDEX `type`(`type`, `type_id`) USING BTREE,
INDEX `user_id`(`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 348 CHARACTER SET = utf8mb4 COMMENT = 'crm团队成员表' ROW_FORMAT = Dynamic;