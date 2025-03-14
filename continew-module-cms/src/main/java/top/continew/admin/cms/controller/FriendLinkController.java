package top.continew.admin.cms.controller;

import top.continew.starter.extension.crud.enums.Api;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import top.continew.starter.extension.crud.annotation.CrudRequestMapping;
import top.continew.admin.common.controller.BaseController;
import top.continew.admin.cms.model.query.FriendLinkQuery;
import top.continew.admin.cms.model.req.FriendLinkReq;
import top.continew.admin.cms.model.resp.FriendLinkDetailResp;
import top.continew.admin.cms.model.resp.FriendLinkResp;
import top.continew.admin.cms.service.FriendLinkService;

/**
 * 友情链接管理 API
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Tag(name = "友情链接管理 API")
@RestController
@CrudRequestMapping(value = "/cms/friendLink", api = {Api.PAGE, Api.DETAIL, Api.ADD, Api.UPDATE, Api.DELETE, Api.EXPORT})
public class FriendLinkController extends BaseController<FriendLinkService, FriendLinkResp, FriendLinkDetailResp, FriendLinkQuery, FriendLinkReq> {}