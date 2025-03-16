SET @parentId = 1901228972485324800;
-- 用户线索标星关系 管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '用户线索标星关系 管理', 1000, 2, '/crm/leadsUserStar', 'LeadsUserStar', 'crm/leadsUserStar/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 用户线索标星关系 管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901228972485324801, '列表', @parentId, 3, 'crm:leadsUserStar:list', 1, 1, 1, NOW()),
    (1901228972485324802, '详情', @parentId, 3, 'crm:leadsUserStar:detail', 2, 1, 1, NOW()),
    (1901228972485324803, '新增', @parentId, 3, 'crm:leadsUserStar:add', 3, 1, 1, NOW()),
    (1901228972485324804, '修改', @parentId, 3, 'crm:leadsUserStar:update', 4, 1, 1, NOW()),
    (1901228972485324805, '删除', @parentId, 3, 'crm:leadsUserStar:delete', 5, 1, 1, NOW()),
    (1901228972485324806, '导出', @parentId, 3, 'crm:leadsUserStar:export', 6, 1, 1, NOW());

