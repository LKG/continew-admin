package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 自定义字段信息
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
@Data
@Schema(description = "自定义字段信息")
public class FieldResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自定义字段英文标识
     */
    @Schema(description = "自定义字段英文标识")
    private String code;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    private String name;

    /**
     * 字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划
     */
    @Schema(description = "字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划")
    private Integer type;

    /**
     * 标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划
     */
    @Schema(description = "标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划")
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
     * 是否唯一 1 是 0 否
     */
    @Schema(description = "是否唯一 1 是 0 否")
    private Integer isUnique;

    /**
     * 是否必填 1 是 0 否
     */
    @Schema(description = "是否必填 1 是 0 否")
    private Integer isNull;

    /**
     * 排序 从小到大
     */
    @Schema(description = "排序 从小到大")
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
     * 是否隐藏  0不隐藏 1隐藏
     */
    @Schema(description = "是否隐藏  0不隐藏 1隐藏")
    private Integer isHidden;

    /**
     * 最后修改时间
     */
    @Schema(description = "最后修改时间")
    private LocalDateTime updateTime;

    /**
     * 字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中
     */
    @Schema(description = "字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中")
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
     * 表单定位 坐标格式： 1,1
     */
    @Schema(description = "表单定位 坐标格式： 1,1")
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

    /**
     * 表单辅助id，前端生成
     */
    @Schema(description = "表单辅助id，前端生成")
    private Integer formAssistId;
}