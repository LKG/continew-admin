package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 线索自定义字段存值详情信息
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "线索自定义字段存值详情信息")
public class LeadsDataDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    @Schema(description = "fieldId")
    @ExcelProperty(value = "fieldId")
    private Long fieldId;

    /**
     * 字段名称
     */
    @Schema(description = "字段名称")
    @ExcelProperty(value = "字段名称")
    private String name;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String value;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String batchId;
}