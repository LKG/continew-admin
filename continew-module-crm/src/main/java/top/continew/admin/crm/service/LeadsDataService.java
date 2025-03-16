package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.LeadsDataQuery;
import top.continew.admin.crm.model.req.LeadsDataReq;
import top.continew.admin.crm.model.resp.LeadsDataDetailResp;
import top.continew.admin.crm.model.resp.LeadsDataResp;

/**
 * 线索自定义字段存值业务接口
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
public interface LeadsDataService extends BaseService<LeadsDataResp, LeadsDataDetailResp, LeadsDataQuery, LeadsDataReq> {}