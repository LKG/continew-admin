package top.continew.admin.cms.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 友情链接查询条件
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@Schema(description = "友情链接查询条件")
public class FriendLinkQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    @Schema(description = "友链名称")
    @Query(type = QueryType.LIKE)
    private String name;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @Query(type = QueryType.BETWEEN)
    private LocalDateTime[] createTime;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @Query(type = QueryType.IN)
    private String[] checkStatus;

    /**
     * 
     */
    @Schema(description = "")
    @Query(type = QueryType.BETWEEN)
    private LocalDateTime[] expiryTime;

    /**
     * 状态
     */
    @Schema(description = "状态")
    @Query(type = QueryType.EQ)
    private Integer status;
}