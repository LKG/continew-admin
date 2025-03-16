package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.LeadsDataMapper;
import top.continew.admin.crm.model.entity.LeadsDataDO;
import top.continew.admin.crm.model.query.LeadsDataQuery;
import top.continew.admin.crm.model.req.LeadsDataReq;
import top.continew.admin.crm.model.resp.LeadsDataDetailResp;
import top.continew.admin.crm.model.resp.LeadsDataResp;
import top.continew.admin.crm.service.LeadsDataService;

/**
 * 线索自定义字段存值业务实现
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
@Service
@RequiredArgsConstructor
public class LeadsDataServiceImpl extends BaseServiceImpl<LeadsDataMapper, LeadsDataDO, LeadsDataResp, LeadsDataDetailResp, LeadsDataQuery, LeadsDataReq> implements LeadsDataService {}