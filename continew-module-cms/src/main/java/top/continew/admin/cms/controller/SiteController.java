package top.continew.admin.cms.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.cms.model.query.SiteQuery;
import top.continew.admin.cms.model.req.SiteReq;
import top.continew.admin.cms.model.resp.SiteDetailResp;
import top.continew.admin.cms.model.resp.SiteResp;
import top.continew.admin.cms.service.SiteService;

/**
 * 站点表管理 API
 *
 * @author gg
 * @since 2025/04/01 19:23
 */
@Tag(name = "站点表管理 API")
@RestController
@CrudRequestMapping(value = "/cms/site", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class SiteController extends BaseController<SiteService, SiteResp, SiteDetailResp, SiteQuery, SiteReq> {}