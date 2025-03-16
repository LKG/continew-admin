package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 用户线索标星关系 详情信息
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "用户线索标星关系 详情信息")
public class LeadsUserStarDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelProperty(value = "用户id")
    private Long userId;

    /**
     * 线索id
     */
    @Schema(description = "线索id")
    @ExcelProperty(value = "线索id")
    private Long leadsId;
}