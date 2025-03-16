package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 线索信息
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Data
@Schema(description = "线索信息")
public class LeadsResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 1已转化 0 未转化
     */
    @Schema(description = "1已转化 0 未转化")
    private Integer isTransform;

    /**
     * 跟进状态 0未跟进1已跟进
     */
    @Schema(description = "跟进状态 0未跟进1已跟进")
    private Integer followup;

    /**
     * 线索名称
     */
    @Schema(description = "线索名称")
    private String leadsName;

    /**
     * 下次联系时间
     */
    @Schema(description = "下次联系时间")
    private LocalDateTime nextTime;

    /**
     * 电话
     */
    @Schema(description = "电话")
    private String telephone;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    private String mobile;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    private String email;

    /**
     * 地址
     */
    @Schema(description = "地址")
    private String address;

    /**
     * 备注
     */
    @Schema(description = "备注")
    private String remark;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Long updateUser;

    /**
     * 批次 比如附件批次
     */
    @Schema(description = "批次 比如附件批次")
    private String batchId;

    /**
     * 最后跟进时间
     */
    @Schema(description = "最后跟进时间")
    private LocalDateTime lastTime;

    /**
     * 最后一条跟进记录
     */
    @Schema(description = "最后一条跟进记录")
    private String lastContent;
}