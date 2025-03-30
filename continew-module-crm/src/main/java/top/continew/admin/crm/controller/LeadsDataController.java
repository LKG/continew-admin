package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.crm.model.query.LeadsDataQuery;
import top.continew.admin.crm.model.req.LeadsDataReq;
import top.continew.admin.crm.model.resp.LeadsDataDetailResp;
import top.continew.admin.crm.model.resp.LeadsDataResp;
import top.continew.admin.crm.service.LeadsDataService;

/**
 * 线索自定义字段存值管理 API
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
@Tag(name = "线索自定义字段存值管理 API")
@RestController
@CrudRequestMapping(value = "/crm/leadsData", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class LeadsDataController extends BaseController<LeadsDataService, LeadsDataResp, LeadsDataDetailResp, LeadsDataQuery, LeadsDataReq> {}