package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.crm.model.query.LeadsQuery;
import top.continew.admin.crm.model.req.LeadsReq;
import top.continew.admin.crm.model.resp.LeadsDetailResp;
import top.continew.admin.crm.model.resp.LeadsResp;
import top.continew.admin.crm.service.LeadsService;

/**
 * 线索管理 API
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Tag(name = "线索管理 API")
@RestController
@CrudRequestMapping(value = "/crm/leads", api = {Api.PAGE, Api.DETAIL, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class LeadsController extends BaseController<LeadsService, LeadsResp, LeadsDetailResp, LeadsQuery, LeadsReq> {}