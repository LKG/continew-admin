package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.FriendLinkMapper;
import top.continew.admin.cms.model.entity.FriendLinkDO;
import top.continew.admin.cms.model.query.FriendLinkQuery;
import top.continew.admin.cms.model.req.FriendLinkReq;
import top.continew.admin.cms.model.resp.FriendLinkDetailResp;
import top.continew.admin.cms.model.resp.FriendLinkResp;
import top.continew.admin.cms.service.FriendLinkService;

/**
 * 友情链接业务实现
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Service
@RequiredArgsConstructor
public class FriendLinkServiceImpl extends BaseServiceImpl<FriendLinkMapper, FriendLinkDO, FriendLinkResp, FriendLinkDetailResp, FriendLinkQuery, FriendLinkReq> implements FriendLinkService {}