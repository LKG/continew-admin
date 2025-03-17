package top.continew.admin.crm.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 字段操作记录实体
 *
 * @author gg
 * @since 2025/03/17 15:53
 */
@Data
@TableName("crm_action_record")
public class ActionRecordDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 模块类型
     */
    private Integer types;

    /**
     * 被操作对象ID
     */
    private Integer actionId;

    /**
     * 对象
     */
    private String object;

    /**
     * 行为
     */
    private Integer behavior;

    /**
     * 内容
     */
    private String content;

    /**
     * 详情
     */
    private String detail;
}