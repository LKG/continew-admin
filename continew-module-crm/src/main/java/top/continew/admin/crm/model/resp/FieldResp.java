package top.continew.admin.crm.model.resp;

import java.io.Serial;
import java.time.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.extension.crud.model.resp.BaseResp;

/**
 * 自定义字段信息
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Data
@Schema(description = "自定义字段信息")
public class FieldResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 英文标识
     */
    @Schema(description = "英文标识")
    private String fieldName;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    private String name;

    /**
     * 字段类型
     */
    @Schema(description = "字段类型")
    private Integer type;

    /**
     * 标签
     */
    @Schema(description = "标签")
    private Integer label;

    /**
     * 字段说明
     */
    @Schema(description = "字段说明")
    private String remark;

    /**
     * 输入提示
     */
    @Schema(description = "输入提示")
    private String inputTips;

    /**
     * 最大长度
     */
    @Schema(description = "最大长度")
    private Integer maxLength;

    /**
     * 默认值
     */
    @Schema(description = "默认值")
    private String defaultValue;

    /**
     * 是否唯一
     */
    @Schema(description = "是否唯一")
    private Integer isUnique;

    /**
     * 是否必填
     */
    @Schema(description = "是否必填")
    private Integer isNull;

    /**
     * 排序
     */
    @Schema(description = "排序")
    private Integer sorting;

    /**
     * 如果类型是选项，此处不能为空，多个选项以，隔开
     */
    @Schema(description = "如果类型是选项，此处不能为空，多个选项以，隔开")
    private String options;

    /**
     * 是否可以删除修改
     */
    @Schema(description = "是否可以删除修改")
    private Integer operating;

    /**
     * 是否隐藏
     */
    @Schema(description = "是否隐藏")
    private Integer isHidden;

    /**
     * 最后修改时间
     */
    @Schema(description = "最后修改时间")
    private LocalDateTime updateTime;

    /**
     * 字段来源
     */
    @Schema(description = "字段来源")
    private Integer fieldType;

    /**
     * 只有线索需要，转换客户的自定义字段ID
     */
    @Schema(description = "只有线索需要，转换客户的自定义字段ID")
    private Integer relevant;

    /**
     * 样式百分比%
     */
    @Schema(description = "样式百分比%")
    private Integer stylePercent;

    /**
     * 精度，允许的最大小数位
     */
    @Schema(description = "精度，允许的最大小数位")
    private Integer precisions;

    /**
     * 表单定位
     */
    @Schema(description = "表单定位")
    private String formPosition;

    /**
     * 限制的最大数值
     */
    @Schema(description = "限制的最大数值")
    private String maxNumRestrict;

    /**
     * 限制的最小数值
     */
    @Schema(description = "限制的最小数值")
    private String minNumRestrict;
}