package top.continew.admin.cms.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.cms.model.query.CommentQuery;
import top.continew.admin.cms.model.req.CommentReq;
import top.continew.admin.cms.model.resp.CommentDetailResp;
import top.continew.admin.cms.model.resp.CommentResp;

/**
 * 评论业务接口
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
public interface CommentService extends BaseService<CommentResp, CommentDetailResp, CommentQuery, CommentReq> {}