package top.continew.admin.cms.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.cms.model.query.SiteQuery;
import top.continew.admin.cms.model.req.SiteReq;
import top.continew.admin.cms.model.resp.SiteDetailResp;
import top.continew.admin.cms.model.resp.SiteResp;

/**
 * 站点表业务接口
 *
 * @author gg
 * @since 2025/04/05 19:44
 */
public interface SiteService extends BaseService<SiteResp, SiteDetailResp, SiteQuery, SiteReq> {}