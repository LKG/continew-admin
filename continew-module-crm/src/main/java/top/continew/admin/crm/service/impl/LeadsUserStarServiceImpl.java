package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.LeadsUserStarMapper;
import top.continew.admin.crm.model.entity.LeadsUserStarDO;
import top.continew.admin.crm.model.query.LeadsUserStarQuery;
import top.continew.admin.crm.model.req.LeadsUserStarReq;
import top.continew.admin.crm.model.resp.LeadsUserStarDetailResp;
import top.continew.admin.crm.model.resp.LeadsUserStarResp;
import top.continew.admin.crm.service.LeadsUserStarService;

/**
 * 用户线索标星关系 业务实现
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Service
@RequiredArgsConstructor
public class LeadsUserStarServiceImpl extends BaseServiceImpl<LeadsUserStarMapper, LeadsUserStarDO, LeadsUserStarResp, LeadsUserStarDetailResp, LeadsUserStarQuery, LeadsUserStarReq> implements LeadsUserStarService {}