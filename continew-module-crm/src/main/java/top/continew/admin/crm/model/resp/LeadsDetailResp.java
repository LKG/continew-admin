package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 线索详情信息
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "线索详情信息")
public class LeadsDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 1已转化 0 未转化
     */
    @Schema(description = "1已转化 0 未转化")
    @ExcelProperty(value = "1已转化 0 未转化")
    private Integer isTransform;

    /**
     * 跟进状态 0未跟进1已跟进
     */
    @Schema(description = "跟进状态 0未跟进1已跟进")
    @ExcelProperty(value = "跟进状态 0未跟进1已跟进")
    private Integer followup;

    /**
     * 线索名称
     */
    @Schema(description = "线索名称")
    @ExcelProperty(value = "线索名称")
    private String leadsName;

    /**
     * 客户id
     */
    @Schema(description = "客户id")
    @ExcelProperty(value = "客户id")
    private Long customerId;

    /**
     * 下次联系时间
     */
    @Schema(description = "下次联系时间")
    @ExcelProperty(value = "下次联系时间")
    private LocalDateTime nextTime;

    /**
     * 电话
     */
    @Schema(description = "电话")
    @ExcelProperty(value = "电话")
    private String telephone;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    @ExcelProperty(value = "手机号")
    private String mobile;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @ExcelProperty(value = "邮箱")
    private String email;

    /**
     * 地址
     */
    @Schema(description = "地址")
    @ExcelProperty(value = "地址")
    private String address;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * 负责人ID
     */
    @Schema(description = "负责人ID")
    @ExcelProperty(value = "负责人ID")
    private Long ownerUserId;

    /**
     * 批次 比如附件批次
     */
    @Schema(description = "批次 比如附件批次")
    @ExcelProperty(value = "批次 比如附件批次")
    private String batchId;

    /**
     * 1 分配
     */
    @Schema(description = "1 分配")
    @ExcelProperty(value = "1 分配")
    private Integer isReceive;

    /**
     * 最后跟进时间
     */
    @Schema(description = "最后跟进时间")
    @ExcelProperty(value = "最后跟进时间")
    private LocalDateTime lastTime;

    /**
     * 最后一条跟进记录
     */
    @Schema(description = "最后一条跟进记录")
    @ExcelProperty(value = "最后一条跟进记录")
    private String lastContent;
}