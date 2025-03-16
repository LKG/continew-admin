package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.OwnerRecordMapper;
import top.continew.admin.crm.model.entity.OwnerRecordDO;
import top.continew.admin.crm.model.query.OwnerRecordQuery;
import top.continew.admin.crm.model.req.OwnerRecordReq;
import top.continew.admin.crm.model.resp.OwnerRecordDetailResp;
import top.continew.admin.crm.model.resp.OwnerRecordResp;
import top.continew.admin.crm.service.OwnerRecordService;

/**
 * 负责人变更记录业务实现
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Service
@RequiredArgsConstructor
public class OwnerRecordServiceImpl extends BaseServiceImpl<OwnerRecordMapper, OwnerRecordDO, OwnerRecordResp, OwnerRecordDetailResp, OwnerRecordQuery, OwnerRecordReq> implements OwnerRecordService {}