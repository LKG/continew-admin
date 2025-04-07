package top.continew.admin.cms.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.cms.model.query.FieldQuery;
import top.continew.admin.cms.model.req.FieldReq;
import top.continew.admin.cms.model.resp.FieldDetailResp;
import top.continew.admin.cms.model.resp.FieldResp;
import top.continew.admin.cms.service.FieldService;

/**
 * 自定义字段管理 API
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
@Tag(name = "自定义字段管理 API")
@RestController
@CrudRequestMapping(value = "/cms/field", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class FieldController extends BaseController<FieldService, FieldResp, FieldDetailResp, FieldQuery, FieldReq> {}