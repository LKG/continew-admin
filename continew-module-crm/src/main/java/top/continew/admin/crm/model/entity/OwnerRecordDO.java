package top.continew.admin.crm.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.continew.starter.extension.crud.model.entity.BaseIdDO;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 负责人变更记录实体
 *
 * @author gg
 * @since 2025/03/16 22:42
 */
@Data
@TableName("crm_owner_record")
public class OwnerRecordDO extends BaseIdDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 对象id
     */
    private Long typeId;

    /**
     * 对象类型
     */
    private Integer type;

    /**
     * 前负责人
     */
    private Long preOwnerUserId;

    /**
     * 接手负责人
     */
    private Long postOwnerUserId;


    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}