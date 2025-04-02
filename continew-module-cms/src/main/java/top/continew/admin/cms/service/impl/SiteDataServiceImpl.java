package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.SiteDataMapper;
import top.continew.admin.cms.model.entity.SiteDataDO;
import top.continew.admin.cms.model.query.SiteDataQuery;
import top.continew.admin.cms.model.req.SiteDataReq;
import top.continew.admin.cms.model.resp.SiteDataDetailResp;
import top.continew.admin.cms.model.resp.SiteDataResp;
import top.continew.admin.cms.service.SiteDataService;

/**
 * 站点自定义字段存值业务实现
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Service
@RequiredArgsConstructor
public class SiteDataServiceImpl extends BaseServiceImpl<SiteDataMapper, SiteDataDO, SiteDataResp, SiteDataDetailResp, SiteDataQuery, SiteDataReq> implements SiteDataService {}