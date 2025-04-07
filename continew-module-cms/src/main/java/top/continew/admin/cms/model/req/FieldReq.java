package top.continew.admin.cms.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改自定义字段参数
 *
 * @author gg
 * @since 2025/04/05 22:54
 */
@Data
@Schema(description = "创建或修改自定义字段参数")
public class FieldReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 自定义字段英文标识
     */
    @Schema(description = "自定义字段英文标识")
    @NotBlank(message = "自定义字段英文标识不能为空")
    @Length(max = 20, message = "自定义字段英文标识长度不能超过 {max} 个字符")
    private String code;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @NotBlank(message = "字段名称不能为空")
    @Length(max = 255, message = "字段名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划
     */
    @Schema(description = "字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划")
    @NotNull(message = "字段类型 1 单行文本 2 多行文本 3 单选 4日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员 11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划不能为空")
    private Integer type;

    /**
     * 标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划
     */
    @Schema(description = "标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划")
    @NotNull(message = "标签 1 线索 2 客户 3 联系人 4 产品 5 商机 6 合同 7回款8.回款计划不能为空")
    private Integer label;

    /**
     * 是否隐藏  0不隐藏 1隐藏
     */
    @Schema(description = "是否隐藏  0不隐藏 1隐藏")
    @NotNull(message = "是否隐藏  0不隐藏 1隐藏不能为空")
    private Integer isHidden;

    /**
     * 字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中
     */
    @Schema(description = "字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中")
    @NotNull(message = "字段来源  0.自定义 1.原始固定 2原始字段但值存在扩展表中不能为空")
    private Integer fieldType;
}