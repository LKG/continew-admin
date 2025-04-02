package top.continew.admin.cms.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 站点自定义字段存值实体
 *
 * @author gg
 * @since 2025/04/01 19:26
 */
@Data
@TableName("cms_site_data")
public class SiteDataDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * fieldId
     */
    private Long fieldId;

    /**
     * 字段编码
     */
    private String code;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 
     */
    private String value;

    /**
     * siteId
     */
    private Long siteId;
}