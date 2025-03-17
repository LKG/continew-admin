package top.continew.admin.crm.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改公海参数
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Data
@Schema(description = "创建或修改公海参数")
public class CustomerPoolReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公海名称
     */
    @Schema(description = "公海名称")
    @NotBlank(message = "公海名称不能为空")
    @Length(max = 255, message = "公海名称长度不能超过 {max} 个字符")
    private String poolName;

    /**
     * 状态 0 停用 1启用
     */
    @Schema(description = "状态 0 停用 1启用")
    @NotNull(message = "状态 0 停用 1启用不能为空")
    private Integer status;

    /**
     * 前负责人领取规则 0不限制 1限制
     */
    @Schema(description = "前负责人领取规则 0不限制 1限制")
    @NotNull(message = "前负责人领取规则 0不限制 1限制不能为空")
    private Integer preOwnerSetting;

    /**
     * 是否限制领取频率 0不限制 1限制
     */
    @Schema(description = "是否限制领取频率 0不限制 1限制")
    @NotNull(message = "是否限制领取频率 0不限制 1限制不能为空")
    private Integer receiveSetting;

    /**
     * 是否设置提前提醒 0不开启 1开启
     */
    @Schema(description = "是否设置提前提醒 0不开启 1开启")
    @NotNull(message = "是否设置提前提醒 0不开启 1开启不能为空")
    private Integer remindSetting;

    /**
     * 收回规则 0不自动收回 1自动收回
     */
    @Schema(description = "收回规则 0不自动收回 1自动收回")
    @NotNull(message = "收回规则 0不自动收回 1自动收回不能为空")
    private Integer putInRule;
}