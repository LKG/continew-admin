package top.continew.admin.crm.model.req;

import java.io.Serial;
import java.time.*;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import top.continew.starter.extension.crud.model.req.BaseReq;

/**
 * 创建或修改自定义字段参数
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Data
@Schema(description = "创建或修改自定义字段参数")
public class FieldReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 英文标识
     */
    @Schema(description = "英文标识")
    @NotBlank(message = "英文标识不能为空")
    @Length(max = 20, message = "英文标识长度不能超过 {max} 个字符")
    private String fieldName;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @NotBlank(message = "字段名称不能为空")
    @Length(max = 255, message = "字段名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 字段类型
     */
    @Schema(description = "字段类型")
    @NotNull(message = "字段类型不能为空")
    private Integer type;

    /**
     * 标签
     */
    @Schema(description = "标签")
    @NotNull(message = "标签不能为空")
    private Integer label;

    /**
     * 是否隐藏
     */
    @Schema(description = "是否隐藏")
    @NotNull(message = "是否隐藏不能为空")
    private Integer isHidden;

    /**
     * 字段来源
     */
    @Schema(description = "字段来源")
    @NotNull(message = "字段来源不能为空")
    private Integer fieldType;
}