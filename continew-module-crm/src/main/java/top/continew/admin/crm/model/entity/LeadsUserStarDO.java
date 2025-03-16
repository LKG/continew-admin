package top.continew.admin.crm.model.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;
import top.continew.starter.extension.crud.model.entity.BaseIdDO;

import java.io.Serial;

/**
 * 用户线索标星关系 实体
 *
 * @author gg
 * @since 2025/03/16 19:08
 */
@Data
@TableName("crm_leads_user_star")
public class LeadsUserStarDO  extends BaseIdDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 线索id
     */
    private Long leadsId;

    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createUser;
}