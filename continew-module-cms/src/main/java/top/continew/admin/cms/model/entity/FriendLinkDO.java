package top.continew.admin.cms.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;
import java.time.*;

/**
 * 友情链接实体
 *
 * @author gg
 * @since 2025/03/14 21:37
 */
@Data
@TableName("cms_friend_link")
public class FriendLinkDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 友链名称
     */
    private String name;

    /**
     * 友链地址
     */
    private String url;

    /**
     * 审核状态
     */
    private String checkStatus;

    /**
     * 
     */
    private LocalDateTime expiryTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * logo
     */
    private String logo;

    /**
     * 上链地址
     */
    private String requestUrl;
}