package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.FieldQuery;
import top.continew.admin.crm.model.req.FieldReq;
import top.continew.admin.crm.model.resp.FieldDetailResp;
import top.continew.admin.crm.model.resp.FieldResp;

/**
 * 自定义字段业务接口
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
public interface FieldService extends BaseService<FieldResp, FieldDetailResp, FieldQuery, FieldReq> {}