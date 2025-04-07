package top.continew.admin.cms.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.cms.mapper.FieldMapper;
import top.continew.admin.cms.model.entity.FieldDO;
import top.continew.admin.cms.model.query.FieldQuery;
import top.continew.admin.cms.model.req.FieldReq;
import top.continew.admin.cms.model.resp.FieldDetailResp;
import top.continew.admin.cms.model.resp.FieldResp;
import top.continew.admin.cms.service.FieldService;

/**
 * 自定义字段业务实现
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
@Service
@RequiredArgsConstructor
public class FieldServiceImpl extends BaseServiceImpl<FieldMapper, FieldDO, FieldResp, FieldDetailResp, FieldQuery, FieldReq> implements FieldService {}