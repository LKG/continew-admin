package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 公海详情信息
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "公海详情信息")
public class CustomerPoolDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公海名称
     */
    @Schema(description = "公海名称")
    @ExcelProperty(value = "公海名称")
    private String poolName;

    /**
     * 管理员 “,”分割
     */
    @Schema(description = "管理员 “,”分割")
    @ExcelProperty(value = "管理员 “,”分割")
    private String adminUserId;

    /**
     * 公海规则员工成员 “,”分割
     */
    @Schema(description = "公海规则员工成员 “,”分割")
    @ExcelProperty(value = "公海规则员工成员 “,”分割")
    private String memberUserId;

    /**
     * 公海规则部门成员 “,”分割
     */
    @Schema(description = "公海规则部门成员 “,”分割")
    @ExcelProperty(value = "公海规则部门成员 “,”分割")
    private String memberDeptId;

    /**
     * 状态 0 停用 1启用
     */
    @Schema(description = "状态 0 停用 1启用")
    @ExcelProperty(value = "状态 0 停用 1启用")
    private Integer status;

    /**
     * 前负责人领取规则 0不限制 1限制
     */
    @Schema(description = "前负责人领取规则 0不限制 1限制")
    @ExcelProperty(value = "前负责人领取规则 0不限制 1限制")
    private Integer preOwnerSetting;

    /**
     * 前负责人领取规则限制天数
     */
    @Schema(description = "前负责人领取规则限制天数")
    @ExcelProperty(value = "前负责人领取规则限制天数")
    private Integer preOwnerSettingDay;

    /**
     * 是否限制领取频率 0不限制 1限制
     */
    @Schema(description = "是否限制领取频率 0不限制 1限制")
    @ExcelProperty(value = "是否限制领取频率 0不限制 1限制")
    private Integer receiveSetting;

    /**
     * 领取频率规则
     */
    @Schema(description = "领取频率规则")
    @ExcelProperty(value = "领取频率规则")
    private Integer receiveNum;

    /**
     * 是否设置提前提醒 0不开启 1开启
     */
    @Schema(description = "是否设置提前提醒 0不开启 1开启")
    @ExcelProperty(value = "是否设置提前提醒 0不开启 1开启")
    private Integer remindSetting;

    /**
     * 提醒规则天数
     */
    @Schema(description = "提醒规则天数")
    @ExcelProperty(value = "提醒规则天数")
    private Integer remindDay;

    /**
     * 收回规则 0不自动收回 1自动收回
     */
    @Schema(description = "收回规则 0不自动收回 1自动收回")
    @ExcelProperty(value = "收回规则 0不自动收回 1自动收回")
    private Integer putInRule;
}