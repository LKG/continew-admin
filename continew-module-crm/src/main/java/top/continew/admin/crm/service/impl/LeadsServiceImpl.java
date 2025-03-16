package top.continew.admin.crm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import top.continew.admin.common.constant.CacheConstants;
import top.continew.admin.common.context.UserContextHolder;
import top.continew.admin.crm.exception.CrmException;
import top.continew.admin.crm.model.entity.LeadsUserStarDO;
import top.continew.admin.crm.service.LeadsUserStarService;
import top.continew.starter.cache.redisson.util.RedisUtils;
import top.continew.starter.extension.crud.service.BaseServiceImpl;
import top.continew.admin.crm.mapper.LeadsMapper;
import top.continew.admin.crm.model.entity.LeadsDO;
import top.continew.admin.crm.model.query.LeadsQuery;
import top.continew.admin.crm.model.req.LeadsReq;
import top.continew.admin.crm.model.resp.LeadsDetailResp;
import top.continew.admin.crm.model.resp.LeadsResp;
import top.continew.admin.crm.service.LeadsService;

import java.util.List;

/**
 * 线索业务实现
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Service
@RequiredArgsConstructor
public class LeadsServiceImpl extends BaseServiceImpl<LeadsMapper, LeadsDO, LeadsResp, LeadsDetailResp, LeadsQuery, LeadsReq> implements LeadsService {

    private final LeadsUserStarService leadsUserStarService;

    final String CRM_BACKLOG_NUM_CACHE_KEY = "queryBackLogNum:";
    /**
     * 修改线索负责人
     *
     * @param leadsIds       线索id列表
     * @param newOwnerUserId 新负责人ID
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void changeOwnerUser(List<Long> leadsIds, Long newOwnerUserId) {
        LambdaUpdateWrapper<LeadsDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.in(LeadsDO::getId, leadsIds);
        wrapper.set(LeadsDO::getOwnerUserId, newOwnerUserId);
        wrapper.set(LeadsDO::getFollowup, 0);
        wrapper.set(LeadsDO::getIsReceive, 1);
        for (Long leadsId : leadsIds) {
            LeadsDO crmLeads = getById(leadsId);
            String key = CRM_BACKLOG_NUM_CACHE_KEY + crmLeads.getOwnerUserId();
            RedisUtils.delete(key);
            //添加负责人变更记录
//            actionRecordUtil.addConversionRecord(leadsId,CrmEnum.LEADS,newOwnerUserId,crmLeads.getLeadsName());
        }
        update(wrapper);
        RedisUtils.delete(CRM_BACKLOG_NUM_CACHE_KEY + newOwnerUserId);
    }

    /**
     * 线索转客户功能
     *
     * @param leadsIds 线索id
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transfer(List<Long> leadsIds) {
        for (Long leadsId : leadsIds) {
//            if (crmLeads.getIsTransform() == 1) {
//                throw new CrmException(CrmCodeEnum.CRM_LEADS_TRANSFER_ERROR);
//            }
        }
    }

    /**
     * 标星
     *
     * @param leadsId 线索id
     */
    @Override
    public void star(Long leadsId) {
        LambdaQueryWrapper<LeadsUserStarDO> wrapper = new LambdaQueryWrapper<>();
        Long userId = UserContextHolder.getUserId();
        wrapper.eq(LeadsUserStarDO::getLeadsId, leadsId);
        wrapper.eq(LeadsUserStarDO::getUserId, userId);
        LeadsUserStarDO star = leadsUserStarService.getOne(wrapper,false);
        if (star == null) {
            star = new LeadsUserStarDO();
            star.setLeadsId(leadsId);
            star.setUserId(userId);
            leadsUserStarService.save(star);
        } else {
            leadsUserStarService.removeById(star.getId());
        }
    }
}