package top.continew.admin.crm.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 负责人变更记录查询条件
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Data
@Schema(description = "负责人变更记录查询条件")
public class OwnerRecordQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}