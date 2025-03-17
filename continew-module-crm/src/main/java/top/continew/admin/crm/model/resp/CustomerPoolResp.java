package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 公海信息
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Data
@Schema(description = "公海信息")
public class CustomerPoolResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公海名称
     */
    @Schema(description = "公海名称")
    private String poolName;

    /**
     * 状态 0 停用 1启用
     */
    @Schema(description = "状态 0 停用 1启用")
    private Integer status;

    /**
     * 前负责人领取规则 0不限制 1限制
     */
    @Schema(description = "前负责人领取规则 0不限制 1限制")
    private Integer preOwnerSetting;

    /**
     * 前负责人领取规则限制天数
     */
    @Schema(description = "前负责人领取规则限制天数")
    private Integer preOwnerSettingDay;

    /**
     * 是否限制领取频率 0不限制 1限制
     */
    @Schema(description = "是否限制领取频率 0不限制 1限制")
    private Integer receiveSetting;

    /**
     * 领取频率规则
     */
    @Schema(description = "领取频率规则")
    private Integer receiveNum;

    /**
     * 是否设置提前提醒 0不开启 1开启
     */
    @Schema(description = "是否设置提前提醒 0不开启 1开启")
    private Integer remindSetting;

    /**
     * 提醒规则天数
     */
    @Schema(description = "提醒规则天数")
    private Integer remindDay;

    /**
     * 收回规则 0不自动收回 1自动收回
     */
    @Schema(description = "收回规则 0不自动收回 1自动收回")
    private Integer putInRule;
}