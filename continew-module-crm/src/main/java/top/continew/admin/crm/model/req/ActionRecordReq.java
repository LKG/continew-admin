package top.continew.admin.crm.model.req;


import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改字段操作记录参数
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Data
@Schema(description = "创建或修改字段操作记录参数")
public class ActionRecordReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}