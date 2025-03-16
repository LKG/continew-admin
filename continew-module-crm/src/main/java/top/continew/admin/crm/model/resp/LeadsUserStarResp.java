package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 用户线索标星关系 信息
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Data
@Schema(description = "用户线索标星关系 信息")
public class LeadsUserStarResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;
}