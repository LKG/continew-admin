SET @parentId = 1901542293927354368;
-- 字段操作记录管理菜单
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `path`, `name`, `component`, `redirect`, `icon`, `is_external`, `is_cache`, `is_hidden`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (@parentId, '字段操作记录管理', 1000, 2, '/crm/actionRecord', 'ActionRecord', 'crm/actionRecord/index', NULL, NULL, b'0', b'0', b'0', NULL, 1, 1, 1, NOW());

-- 字段操作记录管理按钮
INSERT INTO `sys_menu`
    (`id`, `title`, `parent_id`, `type`, `permission`, `sort`, `status`, `create_user`, `create_time`)
VALUES
    (1901542293927354369, '列表', @parentId, 3, 'crm:actionRecord:list', 1, 1, 1, NOW()),
    (1901542293927354370, '详情', @parentId, 3, 'crm:actionRecord:detail', 2, 1, 1, NOW()),
    (1901542293927354371, '新增', @parentId, 3, 'crm:actionRecord:add', 3, 1, 1, NOW()),
    (1901542293927354372, '修改', @parentId, 3, 'crm:actionRecord:update', 4, 1, 1, NOW()),
    (1901542293927354373, '删除', @parentId, 3, 'crm:actionRecord:delete', 5, 1, 1, NOW()),
    (1901542293927354374, '导出', @parentId, 3, 'crm:actionRecord:export', 6, 1, 1, NOW());

