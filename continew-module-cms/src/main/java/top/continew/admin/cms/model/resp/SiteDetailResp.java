package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 站点表详情信息
 *
 * @author gg
 * @since 2025/04/05 19:44
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "站点表详情信息")
public class SiteDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 站点名称
     */
    @Schema(description = "站点名称")
    @ExcelProperty(value = "站点名称")
    private String name;

    /**
     * 域名
     */
    @Schema(description = "域名")
    @ExcelProperty(value = "域名")
    private String domain;

    /**
     * 站点目录
     */
    @Schema(description = "站点目录")
    @ExcelProperty(value = "站点目录")
    private String path;

    /**
     * logo
     */
    @Schema(description = "logo")
    @ExcelProperty(value = "logo")
    private String logo;

    /**
     * 上级站点id
     */
    @Schema(description = "上级站点id")
    @ExcelProperty(value = "上级站点id")
    private Long parentId;

    /**
     * 排序标识
     */
    @Schema(description = "排序标识")
    @ExcelProperty(value = "排序标识")
    private Integer sortNum;
}