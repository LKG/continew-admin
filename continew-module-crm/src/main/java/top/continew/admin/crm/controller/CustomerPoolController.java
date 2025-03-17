package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.crm.model.query.CustomerPoolQuery;
import top.continew.admin.crm.model.req.CustomerPoolReq;
import top.continew.admin.crm.model.resp.CustomerPoolDetailResp;
import top.continew.admin.crm.model.resp.CustomerPoolResp;
import top.continew.admin.crm.service.CustomerPoolService;

/**
 * 公海管理 API
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Tag(name = "公海管理 API")
@RestController
@CrudRequestMapping(value = "/crm/customerPool", api = {Api.PAGE, Api.DETAIL, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class CustomerPoolController extends BaseController<CustomerPoolService, CustomerPoolResp, CustomerPoolDetailResp, CustomerPoolQuery, CustomerPoolReq> {}