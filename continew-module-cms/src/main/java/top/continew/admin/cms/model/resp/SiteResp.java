package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 站点表信息
 *
 * @author gg
 * @since 2025/04/01 19:23
 */
@Data
@Schema(description = "站点表信息")
public class SiteResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 站点名称
     */
    @Schema(description = "站点名称")
    private String name;

    /**
     * 域名
     */
    @Schema(description = "域名")
    private String domain;

    /**
     * logo
     */
    @Schema(description = "logo")
    private String logo;

    /**
     * 上级站点id
     */
    @Schema(description = "上级站点id")
    private Long parentId;

    /**
     * 修改人
     */
    @Schema(description = "修改人")
    private Long updateUser;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;
}