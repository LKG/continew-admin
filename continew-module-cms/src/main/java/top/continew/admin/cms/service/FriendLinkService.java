package top.continew.admin.cms.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.cms.model.query.FriendLinkQuery;
import top.continew.admin.cms.model.req.FriendLinkReq;
import top.continew.admin.cms.model.resp.FriendLinkDetailResp;
import top.continew.admin.cms.model.resp.FriendLinkResp;

/**
 * 友情链接业务接口
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
public interface FriendLinkService extends BaseService<FriendLinkResp, FriendLinkDetailResp, FriendLinkQuery, FriendLinkReq> {}