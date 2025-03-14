package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 友情链接信息
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@Schema(description = "友情链接信息")
public class FriendLinkResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    @Schema(description = "友链名称")
    private String name;

    /**
     * 友链地址
     */
    @Schema(description = "友链地址")
    private String url;

    /**
     * 
     */
    @Schema(description = "")
    private Long updateUser;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
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
    private String remark;

    /**
     * logo
     */
    @Schema(description = "logo")
    private String logo;

    /**
     * 上链地址
     */
    @Schema(description = "上链地址")
    private String requestUrl;
}