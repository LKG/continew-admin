package top.continew.admin.cms.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 站点表实体
 *
 * @author gg
 * @since 2025/04/05 19:44
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
     * 站点目录
     */
    private String path;

    /**
     * logo
     */
    private String logo;

    /**
     * 上级站点id
     */
    private Long parentId;

    /**
     * 排序标识
     */
    private Integer sortNum;
}