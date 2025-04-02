package top.continew.admin.cms.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 站点表查询条件
 *
 * @author gg
 * @since 2025/04/01 19:23
 */
@Data
@Schema(description = "站点表查询条件")
public class SiteQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 站点名称
     */
    @Schema(description = "站点名称")
    @Query(type = QueryType.LIKE)
    private String name;

    /**
     * 域名
     */
    @Schema(description = "域名")
    @Query(type = QueryType.LIKE)
    private String domain;

    /**
     * 上级站点id
     */
    @Schema(description = "上级站点id")
    @Query(type = QueryType.EQ)
    private Long parentId;

    /**
     * 创建人
     */
    @Schema(description = "创建人")
    @Query(type = QueryType.EQ)
    private Long createUser;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @Query(type = QueryType.EQ)
    private LocalDateTime createTime;
}