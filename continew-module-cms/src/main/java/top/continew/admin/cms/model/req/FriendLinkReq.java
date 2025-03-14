package top.continew.admin.cms.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改友情链接参数
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@Schema(description = "创建或修改友情链接参数")
public class FriendLinkReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    @Schema(description = "友链名称")
    @NotBlank(message = "友链名称不能为空")
    @Length(max = 128, message = "友链名称长度不能超过 {max} 个字符")
    private String name;

    /**
     * 友链地址
     */
    @Schema(description = "友链地址")
    @NotBlank(message = "友链地址不能为空")
    @Length(max = 256, message = "友链地址长度不能超过 {max} 个字符")
    private String url;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @NotBlank(message = "审核状态不能为空")
    @Length(max = 32, message = "审核状态长度不能超过 {max} 个字符")
    private String checkStatus;

    /**
     * 
     */
    @Schema(description = "")
    private LocalDateTime expiryTime;

    /**
     * 状态
     */
    @Schema(description = "状态")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @Length(max = 256, message = "备注长度不能超过 {max} 个字符")
    private String remark;

    /**
     * logo
     */
    @Schema(description = "logo")
    @Length(max = 256, message = "logo长度不能超过 {max} 个字符")
    private String logo;

    /**
     * 上链地址
     */
    @Schema(description = "上链地址")
    @Length(max = 256, message = "上链地址长度不能超过 {max} 个字符")
    private String requestUrl;
}