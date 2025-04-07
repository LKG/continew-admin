package top.continew.admin.cms.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.cms.model.query.FieldQuery;
import top.continew.admin.cms.model.req.FieldReq;
import top.continew.admin.cms.model.resp.FieldDetailResp;
import top.continew.admin.cms.model.resp.FieldResp;

/**
 * 自定义字段业务接口
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
public interface FieldService extends BaseService<FieldResp, FieldDetailResp, FieldQuery, FieldReq> {}