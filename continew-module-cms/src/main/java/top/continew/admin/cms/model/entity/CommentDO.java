package top.continew.admin.cms.model.entity;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serial;

/**
 * 评论实体
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Data
@TableName("cms_comment")
public class CommentDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 评论内容
     */
    private String content;

    /**
     * ip地址
     */
    private String userHost;

    /**
     * 
     */
    private String userAgent;

    /**
     * 审核状态
     */
    private String checkStatus;

    /**
     * 评论主题id
     */
    private Long topicId;

    /**
     * 评论主题类型
     */
    private String topicType;

    /**
     * 上一条评论Id
     */
    private Long parentId;

    /**
     * 是否热评
     */
    private Integer isHot;

    /**
     * 是否置顶
     */
    private Integer isTop;

    /**
     * 
     */
    private String userIpInfo;

    /**
     * 
     */
    private String systemHost;

    /**
     * 点赞数量
     */
    private Long rateTimes;

    /**
     * 回复评论用户Id
     */
    private Integer replyUserId;

    /**
     * 回复用户昵称
     */
    private String replyUserNickName;

    /**
     * 回复记录id
     */
    private Long replyId;

    /**
     * siteId
     */
    private Long siteId;
}