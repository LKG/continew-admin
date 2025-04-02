SET @parentId = 1907031919026696192;
-- 站点自定义字段存值管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '站点自定义字段存值管理', 1000, 2, '/cms/siteData', 'SiteData', 'cms/siteData/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 站点自定义字段存值管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1907031919026696193, '列表', @parentId, 3, 'cms:siteData:list', 1, 1, 1, NOW()),
    (1907031919026696194, '详情', @parentId, 3, 'cms:siteData:get', 2, 1, 1, NOW()),
    (1907031919026696195, '新增', @parentId, 3, 'cms:siteData:create', 3, 1, 1, NOW()),
    (1907031919026696196, '修改', @parentId, 3, 'cms:siteData:update', 4, 1, 1, NOW()),
    (1907031919026696197, '删除', @parentId, 3, 'cms:siteData:delete', 5, 1, 1, NOW()),
    (1907031919026696198, '导出', @parentId, 3, 'cms:siteData:export', 6, 1, 1, NOW());

