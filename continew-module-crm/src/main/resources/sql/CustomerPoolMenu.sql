SET @parentId = 1901470668473229312;
-- 公海管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '公海管理', 1000, 2, '/crm/customerPool', 'CustomerPool', 'crm/customerPool/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 公海管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901470668473229313, '列表', @parentId, 3, 'crm:customerPool:list', 1, 1, 1, NOW()),
    (1901470668473229314, '详情', @parentId, 3, 'crm:customerPool:detail', 2, 1, 1, NOW()),
    (1901470668473229315, '新增', @parentId, 3, 'crm:customerPool:add', 3, 1, 1, NOW()),
    (1901470668473229316, '修改', @parentId, 3, 'crm:customerPool:update', 4, 1, 1, NOW()),
    (1901470668473229317, '删除', @parentId, 3, 'crm:customerPool:delete', 5, 1, 1, NOW()),
    (1901470668473229318, '导出', @parentId, 3, 'crm:customerPool:export', 6, 1, 1, NOW());

