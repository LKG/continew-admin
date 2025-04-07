package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.SiteMapper;
import top.continew.admin.cms.model.entity.SiteDO;
import top.continew.admin.cms.model.query.SiteQuery;
import top.continew.admin.cms.model.req.SiteReq;
import top.continew.admin.cms.model.resp.SiteDetailResp;
import top.continew.admin.cms.model.resp.SiteResp;
import top.continew.admin.cms.service.SiteService;

/**
 * 站点表业务实现
 *
 * @author gg
 * @since 2025/04/05 19:44
 */
@Service
@RequiredArgsConstructor
public class SiteServiceImpl extends BaseServiceImpl<SiteMapper, SiteDO, SiteResp, SiteDetailResp, SiteQuery, SiteReq> implements SiteService {}