package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.OwnerRecordQuery;
import top.continew.admin.crm.model.req.OwnerRecordReq;
import top.continew.admin.crm.model.resp.OwnerRecordDetailResp;
import top.continew.admin.crm.model.resp.OwnerRecordResp;

/**
 * 负责人变更记录业务接口
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
public interface OwnerRecordService extends BaseService<OwnerRecordResp, OwnerRecordDetailResp, OwnerRecordQuery, OwnerRecordReq> {}