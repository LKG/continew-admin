package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.CommentMapper;
import top.continew.admin.cms.model.entity.CommentDO;
import top.continew.admin.cms.model.query.CommentQuery;
import top.continew.admin.cms.model.req.CommentReq;
import top.continew.admin.cms.model.resp.CommentDetailResp;
import top.continew.admin.cms.model.resp.CommentResp;
import top.continew.admin.cms.service.CommentService;

/**
 * 评论业务实现
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends BaseServiceImpl<CommentMapper, CommentDO, CommentResp, CommentDetailResp, CommentQuery, CommentReq> implements CommentService {}