package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.ActionRecordQuery;
import top.continew.admin.crm.model.req.ActionRecordReq;
import top.continew.admin.crm.model.resp.ActionRecordDetailResp;
import top.continew.admin.crm.model.resp.ActionRecordResp;

/**
 * 字段操作记录业务接口
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
public interface ActionRecordService extends BaseService<ActionRecordResp, ActionRecordDetailResp, ActionRecordQuery, ActionRecordReq> {}