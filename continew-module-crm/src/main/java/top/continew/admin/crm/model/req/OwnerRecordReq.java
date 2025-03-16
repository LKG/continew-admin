package top.continew.admin.crm.model.req;


import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改负责人变更记录参数
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Data
@Schema(description = "创建或修改负责人变更记录参数")
public class OwnerRecordReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}