package top.continew.admin.crm.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 线索查询条件
 *
 * @author gg
 * @since 2025/03/16 18:53
 */
@Data
@Schema(description = "线索查询条件")
public class LeadsQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 1已转化 0 未转化
     */
    @Schema(description = "1已转化 0 未转化")
    @Query(type = QueryType.EQ)
    private Integer isTransform;

    /**
     * 线索名称
     */
    @Schema(description = "线索名称")
    @Query(type = QueryType.LIKE)
    private String leadsName;

    /**
     * 邮箱
     */
    @Schema(description = "邮箱")
    @Query(type = QueryType.LIKE)
    private String email;

    /**
     * 批次 比如附件批次
     */
    @Schema(description = "批次 比如附件批次")
    @Query(type = QueryType.EQ)
    private String batchId;
}