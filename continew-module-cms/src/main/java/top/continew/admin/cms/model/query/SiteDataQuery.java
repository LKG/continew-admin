package top.continew.admin.cms.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 站点自定义字段存值查询条件
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Data
@Schema(description = "站点自定义字段存值查询条件")
public class SiteDataQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    @Schema(description = "fieldId")
    @Query(type = QueryType.EQ)
    private Long fieldId;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @Query(type = QueryType.EQ)
    private String name;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @Query(type = QueryType.EQ)
    private LocalDateTime createTime;
}