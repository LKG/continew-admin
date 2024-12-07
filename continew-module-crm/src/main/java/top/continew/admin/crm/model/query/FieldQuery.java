package top.continew.admin.crm.model.query;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

/**
 * 自定义字段查询条件
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Data
@Schema(description = "自定义字段查询条件")
public class FieldQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 英文标识
     */
    @Schema(description = "英文标识")
    @Query(type = QueryType.EQ)
    private String fieldName;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @Query(type = QueryType.EQ)
    private String name;

    /**
     * 字段类型
     */
    @Schema(description = "字段类型")
    @Query(type = QueryType.EQ)
    private Integer type;

    /**
     * 标签
     */
    @Schema(description = "标签")
    @Query(type = QueryType.EQ)
    private Integer label;

    /**
     * 是否隐藏
     */
    @Schema(description = "是否隐藏")
    @Query(type = QueryType.EQ)
    private Integer isHidden;

    /**
     * 字段来源
     */
    @Schema(description = "字段来源")
    @Query(type = QueryType.EQ)
    private Integer fieldType;
}