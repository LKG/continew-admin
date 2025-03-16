package top.continew.admin.crm.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 用户线索标星关系 查询条件
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Data
@Schema(description = "用户线索标星关系 查询条件")
public class LeadsUserStarQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}