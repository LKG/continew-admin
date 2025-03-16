package top.continew.admin.crm.service;

import top.continew.starter.extension.crud.service.BaseService;
import top.continew.admin.crm.model.query.LeadsQuery;
import top.continew.admin.crm.model.req.LeadsReq;
import top.continew.admin.crm.model.resp.LeadsDetailResp;
import top.continew.admin.crm.model.resp.LeadsResp;

import java.util.List;

/**
 * 线索业务接口
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
public interface LeadsService extends BaseService<LeadsResp, LeadsDetailResp, LeadsQuery, LeadsReq> {

    /**
     * 修改线索负责人
     *
     * @param leadsIds       线索id列表
     * @param newOwnerUserId 新负责人ID
     */
    void changeOwnerUser(List<Long> leadsIds, Long newOwnerUserId);

    /**
     * 线索转客户功能
     *
     * @param leadsIds 线索id
     */
    void transfer(List<Long> leadsIds);

    /**
     * 标星
     * @param leadsId 线索id
     */
    void star(Long leadsId);


}