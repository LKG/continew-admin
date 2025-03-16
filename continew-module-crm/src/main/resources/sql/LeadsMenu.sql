SET @parentId = 1901225206621081600;
-- 线索管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '线索管理', 1000, 2, '/crm/leads', 'Leads', 'crm/leads/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 线索管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901225206621081601, '列表', @parentId, 3, 'crm:leads:list', 1, 1, 1, NOW()),
    (1901225206621081602, '详情', @parentId, 3, 'crm:leads:detail', 2, 1, 1, NOW()),
    (1901225206621081603, '新增', @parentId, 3, 'crm:leads:add', 3, 1, 1, NOW()),
    (1901225206621081604, '修改', @parentId, 3, 'crm:leads:update', 4, 1, 1, NOW()),
    (1901225206621081605, '删除', @parentId, 3, 'crm:leads:delete', 5, 1, 1, NOW()),
    (1901225206621081606, '导出', @parentId, 3, 'crm:leads:export', 6, 1, 1, NOW());

