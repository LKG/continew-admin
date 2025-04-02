SET @parentId = 1907031059072770048;
-- 站点表管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '站点表管理', 1000, 2, '/generator/site', 'Site', 'generator/site/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 站点表管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1907031059072770049, '列表', @parentId, 3, 'generator:site:list', 1, 1, 1, NOW()),
    (1907031059072770050, '详情', @parentId, 3, 'generator:site:get', 2, 1, 1, NOW()),
    (1907031059072770051, '新增', @parentId, 3, 'generator:site:create', 3, 1, 1, NOW()),
    (1907031059072770052, '修改', @parentId, 3, 'generator:site:update', 4, 1, 1, NOW()),
    (1907031059072770053, '删除', @parentId, 3, 'generator:site:delete', 5, 1, 1, NOW()),
    (1907031059072770054, '导出', @parentId, 3, 'generator:site:export', 6, 1, 1, NOW());

