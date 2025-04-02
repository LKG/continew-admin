package top.continew.admin.cms.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.cms.model.query.SiteDataQuery;
import top.continew.admin.cms.model.req.SiteDataReq;
import top.continew.admin.cms.model.resp.SiteDataDetailResp;
import top.continew.admin.cms.model.resp.SiteDataResp;
import top.continew.admin.cms.service.SiteDataService;

/**
 * 站点自定义字段存值管理 API
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Tag(name = "站点自定义字段存值管理 API")
@RestController
@CrudRequestMapping(value = "/cms/siteData", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class SiteDataController extends BaseController<SiteDataService, SiteDataResp, SiteDataDetailResp, SiteDataQuery, SiteDataReq> {}