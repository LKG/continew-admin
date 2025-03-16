package top.continew.admin.crm.model.req;


import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改用户线索标星关系 参数
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Data
@Schema(description = "创建或修改用户线索标星关系 参数")
public class LeadsUserStarReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}