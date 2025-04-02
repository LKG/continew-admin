package top.continew.admin.cms.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.cms.model.query.SiteDataQuery;
import top.continew.admin.cms.model.req.SiteDataReq;
import top.continew.admin.cms.model.resp.SiteDataDetailResp;
import top.continew.admin.cms.model.resp.SiteDataResp;

/**
 * 站点自定义字段存值业务接口
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
public interface SiteDataService extends BaseService<SiteDataResp, SiteDataDetailResp, SiteDataQuery, SiteDataReq> {}