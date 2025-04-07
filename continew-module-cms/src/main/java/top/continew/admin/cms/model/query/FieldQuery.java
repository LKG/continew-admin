package top.continew.admin.cms.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 自定义字段查询条件
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
@Data
@Schema(description = "自定义字段查询条件")
public class FieldQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自定义字段英文标识
     */
    @Schema(description = "自定义字段英文标识")
    @Query(type = QueryType.EQ)
    private String code;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @Query(type = QueryType.EQ)
    private String name;

    /**
     * 字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划
     */
    @Schema(description = "字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划")
    @Query(type = QueryType.EQ)
    private Integer type;

    /**
     * 标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划
     */
    @Schema(description = "标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划")
    @Query(type = QueryType.EQ)
    private Integer label;

    /**
     * 是否隐藏  0不隐藏 1隐藏
     */
    @Schema(description = "是否隐藏  0不隐藏 1隐藏")
    @Query(type = QueryType.EQ)
    private Integer isHidden;

    /**
     * 字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中
     */
    @Schema(description = "字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中")
    @Query(type = QueryType.EQ)
    private Integer fieldType;
}