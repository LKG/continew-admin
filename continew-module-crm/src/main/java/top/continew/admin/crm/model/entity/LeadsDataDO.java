package top.continew.admin.crm.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 线索自定义字段存值实体
 *
 * @author gg
 * @since 2025/03/16 18:54
 */
@Data
@TableName("crm_leads_data")
public class LeadsDataDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    private Long fieldId;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 
     */
    private String value;

    /**
     * 
     */
    private String batchId;
}