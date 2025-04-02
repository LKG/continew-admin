package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 站点自定义字段存值信息
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Data
@Schema(description = "站点自定义字段存值信息")
public class SiteDataResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    @Schema(description = "fieldId")
    private Long fieldId;

    /**
     * 字段编码
     */
    @Schema(description = "字段编码")
    private String code;

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
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 
     */
    @Schema(description = "")
    private Long updateUser;
}