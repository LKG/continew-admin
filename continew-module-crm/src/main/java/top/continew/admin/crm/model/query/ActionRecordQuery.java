package top.continew.admin.crm.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 字段操作记录查询条件
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Data
@Schema(description = "字段操作记录查询条件")
public class ActionRecordQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ip地址
     */
    @Schema(description = "ip地址")
    @Query(type = QueryType.EQ)
    private String ipAddress;
}