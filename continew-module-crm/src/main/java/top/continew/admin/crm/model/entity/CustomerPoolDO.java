package top.continew.admin.crm.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 公海实体
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Data
@TableName("crm_customer_pool")
public class CustomerPoolDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公海名称
     */
    private String poolName;

    /**
     * 管理员 “,”分割
     */
    private String adminUserId;

    /**
     * 公海规则员工成员 “,”分割
     */
    private String memberUserId;

    /**
     * 公海规则部门成员 “,”分割
     */
    private String memberDeptId;

    /**
     * 状态 0 停用 1启用
     */
    private Integer status;

    /**
     * 前负责人领取规则 0不限制 1限制
     */
    private Integer preOwnerSetting;

    /**
     * 前负责人领取规则限制天数
     */
    private Integer preOwnerSettingDay;

    /**
     * 是否限制领取频率 0不限制 1限制
     */
    private Integer receiveSetting;

    /**
     * 领取频率规则
     */
    private Integer receiveNum;

    /**
     * 是否设置提前提醒 0不开启 1开启
     */
    private Integer remindSetting;

    /**
     * 提醒规则天数
     */
    private Integer remindDay;

    /**
     * 收回规则 0不自动收回 1自动收回
     */
    private Integer putInRule;
}