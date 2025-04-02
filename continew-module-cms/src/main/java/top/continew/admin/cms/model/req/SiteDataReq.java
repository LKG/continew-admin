package top.continew.admin.cms.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改站点自定义字段存值参数
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Data
@Schema(description = "创建或修改站点自定义字段存值参数")
public class SiteDataReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    @Schema(description = "fieldId")
    @NotNull(message = "fieldId不能为空")
    private Long fieldId;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @NotBlank(message = "字段名称不能为空")
    @Length(max = 255, message = "字段名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDateTime createTime;
}