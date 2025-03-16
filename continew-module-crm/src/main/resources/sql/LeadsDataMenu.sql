SET @parentId = 1901225664798461952;
-- 线索自定义字段存值管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '线索自定义字段存值管理', 1000, 2, '/crm/leadsData', 'LeadsData', 'crm/leadsData/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 线索自定义字段存值管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901225664798461953, '列表', @parentId, 3, 'crm:leadsData:list', 1, 1, 1, NOW()),
    (1901225664798461954, '详情', @parentId, 3, 'crm:leadsData:detail', 2, 1, 1, NOW()),
    (1901225664798461955, '新增', @parentId, 3, 'crm:leadsData:add', 3, 1, 1, NOW()),
    (1901225664798461956, '修改', @parentId, 3, 'crm:leadsData:update', 4, 1, 1, NOW()),
    (1901225664802656256, '删除', @parentId, 3, 'crm:leadsData:delete', 5, 1, 1, NOW()),
    (1901225664802656257, '导出', @parentId, 3, 'crm:leadsData:export', 6, 1, 1, NOW());

