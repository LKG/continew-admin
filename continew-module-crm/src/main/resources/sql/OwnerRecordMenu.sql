SET @parentId = 1901282941597376512;
-- 负责人变更记录管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '负责人变更记录管理', 1000, 2, '/crm/ownerRecord', 'OwnerRecord', 'crm/ownerRecord/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 负责人变更记录管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901282941597376513, '列表', @parentId, 3, 'crm:ownerRecord:list', 1, 1, 1, NOW()),
    (1901282941597376514, '详情', @parentId, 3, 'crm:ownerRecord:detail', 2, 1, 1, NOW()),
    (1901282941597376515, '新增', @parentId, 3, 'crm:ownerRecord:add', 3, 1, 1, NOW()),
    (1901282941597376516, '修改', @parentId, 3, 'crm:ownerRecord:update', 4, 1, 1, NOW()),
    (1901282941597376517, '删除', @parentId, 3, 'crm:ownerRecord:delete', 5, 1, 1, NOW()),
    (1901282941597376518, '导出', @parentId, 3, 'crm:ownerRecord:export', 6, 1, 1, NOW());

