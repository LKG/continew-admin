package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.crm.model.query.ActionRecordQuery;
import top.continew.admin.crm.model.req.ActionRecordReq;
import top.continew.admin.crm.model.resp.ActionRecordDetailResp;
import top.continew.admin.crm.model.resp.ActionRecordResp;
import top.continew.admin.crm.service.ActionRecordService;

/**
 * 字段操作记录管理 API
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Tag(name = "字段操作记录管理 API")
@RestController
@CrudRequestMapping(value = "/crm/actionRecord", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class ActionRecordController extends BaseController<ActionRecordService, ActionRecordResp, ActionRecordDetailResp, ActionRecordQuery, ActionRecordReq> {}