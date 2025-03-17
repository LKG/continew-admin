package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.CustomerPoolQuery;
import top.continew.admin.crm.model.req.CustomerPoolReq;
import top.continew.admin.crm.model.resp.CustomerPoolDetailResp;
import top.continew.admin.crm.model.resp.CustomerPoolResp;

import java.util.List;

/**
 * 公海业务接口
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
public interface CustomerPoolService extends BaseService<CustomerPoolResp, CustomerPoolDetailResp, CustomerPoolQuery, CustomerPoolReq> {


    /**
     * 修改公海状态
     * @param poolId 公海ID
     * @param status 状态
     */
    void changeStatus(Long poolId, Long status);

    /**
     *
     * @param prePoolId 原公海ID
     * @param postPoolId 转移的公海ID
     */
    void transfer(Long prePoolId, Long postPoolId);
}