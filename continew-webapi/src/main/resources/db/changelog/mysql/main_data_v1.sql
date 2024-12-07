-- liquibase formatted sql
-- changeset gg:1
-- comment 初始化表数据
-- 设置

INSERT INTO `sys_option`
(`id`, `category`, `name`, `code`, `value`, `default_value`, `description`, `update_user`, `update_time`)
VALUES
    (23, 'DOMAIN', '域名', 'DOMAIN', NULL, 'www.gongwk.cn', '域名配置', NULL, NULL);
