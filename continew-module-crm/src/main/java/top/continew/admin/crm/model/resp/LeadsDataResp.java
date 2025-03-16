package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 线索自定义字段存值信息
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
@Data
@Schema(description = "线索自定义字段存值信息")
public class LeadsDataResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    @Schema(description = "fieldId")
    private Long fieldId;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    private String name;

    /**
     * 
     */
    @Schema(description = "")
    private String value;

    /**
     * 
     */
    @Schema(description = "")
    private String batchId;
}