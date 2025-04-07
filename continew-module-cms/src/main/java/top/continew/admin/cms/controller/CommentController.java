package top.continew.admin.cms.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.cms.model.query.CommentQuery;
import top.continew.admin.cms.model.req.CommentReq;
import top.continew.admin.cms.model.resp.CommentDetailResp;
import top.continew.admin.cms.model.resp.CommentResp;
import top.continew.admin.cms.service.CommentService;

/**
 * 评论管理 API
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Tag(name = "评论管理 API")
@RestController
@CrudRequestMapping(value = "/cms/comment", api = {Api.PAGE, Api.GET, Api.CREATE, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class CommentController extends BaseController<CommentService, CommentResp, CommentDetailResp, CommentQuery, CommentReq> {}