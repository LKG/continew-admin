package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.ActionRecordMapper;
import top.continew.admin.crm.model.entity.ActionRecordDO;
import top.continew.admin.crm.model.query.ActionRecordQuery;
import top.continew.admin.crm.model.req.ActionRecordReq;
import top.continew.admin.crm.model.resp.ActionRecordDetailResp;
import top.continew.admin.crm.model.resp.ActionRecordResp;
import top.continew.admin.crm.service.ActionRecordService;

/**
 * 字段操作记录业务实现
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Service
@RequiredArgsConstructor
public class ActionRecordServiceImpl extends BaseServiceImpl<ActionRecordMapper, ActionRecordDO, ActionRecordResp, ActionRecordDetailResp, ActionRecordQuery, ActionRecordReq> implements ActionRecordService {}