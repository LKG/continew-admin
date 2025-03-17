package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 字段操作记录信息
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Data
@Schema(description = "字段操作记录信息")
public class ActionRecordResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ip地址
     */
    @Schema(description = "ip地址")
    private String ipAddress;

    /**
     * 模块类型
     */
    @Schema(description = "模块类型")
    private Integer types;

    /**
     * 被操作对象ID
     */
    @Schema(description = "被操作对象ID")
    private Integer actionId;

    /**
     * 对象
     */
    @Schema(description = "对象")
    private String object;

    /**
     * 行为
     */
    @Schema(description = "行为")
    private Integer behavior;

    /**
     * 内容
     */
    @Schema(description = "内容")
    private String content;

    /**
     * 详情
     */
    @Schema(description = "详情")
    private String detail;
}