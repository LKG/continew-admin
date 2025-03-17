package top.continew.admin.crm.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 公海查询条件
 *
 * @author gg
 * @since 2025/03/17 11:08
 */
@Data
@Schema(description = "公海查询条件")
public class CustomerPoolQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 公海名称
     */
    @Schema(description = "公海名称")
    @Query(type = QueryType.EQ)
    private String poolName;

    /**
     * 管理员 “,”分割
     */
    @Schema(description = "管理员 “,”分割")
    @Query(type = QueryType.EQ)
    private String adminUserId;

    /**
     * 状态 0 停用 1启用
     */
    @Schema(description = "状态 0 停用 1启用")
    @Query(type = QueryType.EQ)
    private Integer status;

    /**
     * 前负责人领取规则 0不限制 1限制
     */
    @Schema(description = "前负责人领取规则 0不限制 1限制")
    @Query(type = QueryType.EQ)
    private Integer preOwnerSetting;

    /**
     * 是否限制领取频率 0不限制 1限制
     */
    @Schema(description = "是否限制领取频率 0不限制 1限制")
    @Query(type = QueryType.EQ)
    private Integer receiveSetting;

    /**
     * 是否设置提前提醒 0不开启 1开启
     */
    @Schema(description = "是否设置提前提醒 0不开启 1开启")
    @Query(type = QueryType.EQ)
    private Integer remindSetting;

    /**
     * 收回规则 0不自动收回 1自动收回
     */
    @Schema(description = "收回规则 0不自动收回 1自动收回")
    @Query(type = QueryType.EQ)
    private Integer putInRule;
}