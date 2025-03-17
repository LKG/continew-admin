package top.continew.admin.crm.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.CustomerPoolMapper;
import top.continew.admin.crm.model.entity.CustomerPoolDO;
import top.continew.admin.crm.model.query.CustomerPoolQuery;
import top.continew.admin.crm.model.req.CustomerPoolReq;
import top.continew.admin.crm.model.resp.CustomerPoolDetailResp;
import top.continew.admin.crm.model.resp.CustomerPoolResp;
import top.continew.admin.crm.service.CustomerPoolService;

/**
 * 公海业务实现
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Service
@RequiredArgsConstructor
public class CustomerPoolServiceImpl extends BaseServiceImpl<CustomerPoolMapper, CustomerPoolDO, CustomerPoolResp, CustomerPoolDetailResp, CustomerPoolQuery, CustomerPoolReq> implements CustomerPoolService {

    /**
     * 修改公海状态
     *
     * @param poolId 公海ID
     * @param status 状态
     */
    @Override
    public void changeStatus(Long poolId, Long status) {

    }

    /**
     * @param prePoolId  原公海ID
     * @param postPoolId 转移的公海ID
     */
    @Override
    public void transfer(Long prePoolId, Long postPoolId) {

    }
}