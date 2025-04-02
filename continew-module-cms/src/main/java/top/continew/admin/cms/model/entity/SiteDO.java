package top.continew.admin.cms.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 站点表实体
 *
 * @author gg
 * @since 2025/04/01 19:23
 */
@Data
@TableName("cms_site")
public class SiteDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 站点名称
     */
    private String name;

    /**
     * 域名
     */
    private String domain;

    /**
     * logo
     */
    private String logo;

    /**
     * 上级站点id
     */
    private Long parentId;
}