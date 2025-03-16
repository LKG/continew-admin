package top.continew.admin.crm.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改线索参数
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Data
@Schema(description = "创建或修改线索参数")
public class LeadsReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 1已转化 0 未转化
     */
    @Schema(description = "1已转化 0 未转化")
    private Integer isTransform;

    /**
     * 线索名称
     */
    @Schema(description = "线索名称")
    @Length(max = 255, message = "线索名称长度不能超过 {max} 个字符")
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
    @Length(max = 100, message = "电话长度不能超过 {max} 个字符")
    private String telephone;

    /**
     * 手机号
     */
    @Schema(description = "手机号")
    @Length(max = 100, message = "手机号长度不能超过 {max} 个字符")
    private String mobile;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @Length(max = 100, message = "邮箱长度不能超过 {max} 个字符")
    private String email;

    /**
     * 地址
     */
    @Schema(description = "地址")
    @Length(max = 100, message = "地址长度不能超过 {max} 个字符")
    private String address;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 800, message = "备注长度不能超过 {max} 个字符")
    private String remark;

    /**
     * 批次 比如附件批次
     */
    @Schema(description = "批次 比如附件批次")
    @NotBlank(message = "批次 比如附件批次不能为空")
    @Length(max = 32, message = "批次 比如附件批次长度不能超过 {max} 个字符")
    private String batchId;
}