package top.continew.admin.crm.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;
import java.time.*;

/**
 * 线索实体
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Data
@TableName("crm_leads")
public class LeadsDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 1已转化 0 未转化
     */
    private Integer isTransform;

    /**
     * 跟进状态 0未跟进1已跟进
     */
    private Integer followup;

    /**
     * 线索名称
     */
    private String leadsName;

    /**
     * 客户id
     */
    private Long customerId;

    /**
     * 下次联系时间
     */
    private LocalDateTime nextTime;

    /**
     * 电话
     */
    private String telephone;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 备注
     */
    private String remark;

    /**
     * 负责人ID
     */
    private Long ownerUserId;

    /**
     * 批次 比如附件批次
     */
    private String batchId;

    /**
     * 1 分配
     */
    private Integer isReceive;

    /**
     * 最后跟进时间
     */
    private LocalDateTime lastTime;

    /**
     * 最后一条跟进记录
     */
    private String lastContent;
}