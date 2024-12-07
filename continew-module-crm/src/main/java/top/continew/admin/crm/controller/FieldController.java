package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.starter.extension.crud.controller.BaseController;
import top.continew.admin.crm.model.query.FieldQuery;
import top.continew.admin.crm.model.req.FieldReq;
import top.continew.admin.crm.model.resp.FieldDetailResp;
import top.continew.admin.crm.model.resp.FieldResp;
import top.continew.admin.crm.service.FieldService;

/**
 * 自定义字段管理 API
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Tag(name = "自定义字段管理 API")
@RestController
@CrudRequestMapping(value = "/crm/field", api = {Api.PAGE, Api.DETAIL, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class FieldController extends BaseController<FieldService, FieldResp, FieldDetailResp, FieldQuery, FieldReq> {}