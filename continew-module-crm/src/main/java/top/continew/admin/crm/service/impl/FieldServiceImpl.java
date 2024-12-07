package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.impl.BaseServiceImpl;
import top.continew.admin.crm.mapper.FieldMapper;
import top.continew.admin.crm.model.entity.FieldDO;
import top.continew.admin.crm.model.query.FieldQuery;
import top.continew.admin.crm.model.req.FieldReq;
import top.continew.admin.crm.model.resp.FieldDetailResp;
import top.continew.admin.crm.model.resp.FieldResp;
import top.continew.admin.crm.service.FieldService;

/**
 * 自定义字段业务实现
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Service
@RequiredArgsConstructor
public class FieldServiceImpl extends BaseServiceImpl<FieldMapper, FieldDO, FieldResp, FieldDetailResp, FieldQuery, FieldReq> implements FieldService {}