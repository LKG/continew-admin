package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 负责人变更记录详情信息
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "负责人变更记录详情信息")
public class OwnerRecordDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对象id
     */
    @Schema(description = "对象id")
    @ExcelProperty(value = "对象id")
    private Long typeId;

    /**
     * 对象类型
     */
    @Schema(description = "对象类型")
    @ExcelProperty(value = "对象类型")
    private Integer type;

    /**
     * 前负责人
     */
    @Schema(description = "前负责人")
    @ExcelProperty(value = "前负责人")
    private Long preOwnerUserId;

    /**
     * 接手负责人
     */
    @Schema(description = "接手负责人")
    @ExcelProperty(value = "接手负责人")
    private Long postOwnerUserId;
}