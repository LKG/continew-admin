package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 友情链接详情信息
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "友情链接详情信息")
public class FriendLinkDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    @Schema(description = "友链名称")
    @ExcelProperty(value = "友链名称")
    private String name;

    /**
     * 友链地址
     */
    @Schema(description = "友链地址")
    @ExcelProperty(value = "友链地址")
    private String url;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @ExcelProperty(value = "审核状态")
    private String checkStatus;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private LocalDateTime expiryTime;

    /**
     * 状态
     */
    @Schema(description = "状态")
    @ExcelProperty(value = "状态")
    private Integer status;

    /**
     * 备注
     */
    @Schema(description = "备注")
    @ExcelProperty(value = "备注")
    private String remark;

    /**
     * logo
     */
    @Schema(description = "logo")
    @ExcelProperty(value = "logo")
    private String logo;

    /**
     * 上链地址
     */
    @Schema(description = "上链地址")
    @ExcelProperty(value = "上链地址")
    private String requestUrl;
}