package top.continew.admin.crm.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.crm.model.query.OwnerRecordQuery;
import top.continew.admin.crm.model.req.OwnerRecordReq;
import top.continew.admin.crm.model.resp.OwnerRecordDetailResp;
import top.continew.admin.crm.model.resp.OwnerRecordResp;
import top.continew.admin.crm.service.OwnerRecordService;

/**
 * 负责人变更记录管理 API
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Tag(name = "负责人变更记录管理 API")
@RestController
@CrudRequestMapping(value = "/crm/ownerRecord", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class OwnerRecordController extends BaseController<OwnerRecordService, OwnerRecordResp, OwnerRecordDetailResp, OwnerRecordQuery, OwnerRecordReq> {}