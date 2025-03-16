package top.continew.admin.crm.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 负责人变更记录信息
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Data
@Schema(description = "负责人变更记录信息")
public class OwnerRecordResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;
}