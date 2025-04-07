package top.continew.admin.cms.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改站点表参数
 *
 * @author gg
 * @since 2025/04/05 19:44
 */
@Data
@Schema(description = "创建或修改站点表参数")
public class SiteReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 站点名称
     */
    @Schema(description = "站点名称")
    @NotBlank(message = "站点名称不能为空")
    @Length(max = 255, message = "站点名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 域名
     */
    @Schema(description = "域名")
    @Length(max = 100, message = "域名长度不能超过 {max} 个字符")
    private String domain;

    /**
     * 站点目录
     */
    @Schema(description = "站点目录")
    @Length(max = 255, message = "站点目录长度不能超过 {max} 个字符")
    private String path;

    /**
     * logo
     */
    @Schema(description = "logo")
    @Length(max = 255, message = "logo长度不能超过 {max} 个字符")
    private String logo;

    /**
     * 上级站点id
     */
    @Schema(description = "上级站点id")
    @NotNull(message = "上级站点id不能为空")
    private Long parentId;

    /**
     * 排序标识
     */
    @Schema(description = "排序标识")
    @NotNull(message = "排序标识不能为空")
    private Integer sortNum;
}