package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.admin.common.model.resp.BaseResp;

import java.io.Serial;
import java.time.*;

/**
 * 评论信息
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Data
@Schema(description = "评论信息")
public class CommentResp extends BaseResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    private Long userId;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String nickName;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    private String avatar;

    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    private String content;

    /**
     * ip地址
     */
    @Schema(description = "ip地址")
    private String userHost;

    /**
     * 
     */
    @Schema(description = "")
    private String userAgent;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    private String checkStatus;

    /**
     * 评论主题id
     */
    @Schema(description = "评论主题id")
    private Long topicId;

    /**
     * 评论主题类型
     */
    @Schema(description = "评论主题类型")
    private String topicType;

    /**
     * 上一条评论Id
     */
    @Schema(description = "上一条评论Id")
    private Long parentId;

    /**
     * 是否热评
     */
    @Schema(description = "是否热评")
    private Integer isHot;

    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    private Integer isTop;

    /**
     * 
     */
    @Schema(description = "")
    private String userIpInfo;

    /**
     * 
     */
    @Schema(description = "")
    private String systemHost;

    /**
     * 点赞数量
     */
    @Schema(description = "点赞数量")
    private Long rateTimes;

    /**
     * 回复评论用户Id
     */
    @Schema(description = "回复评论用户Id")
    private Integer replyUserId;

    /**
     * 回复用户昵称
     */
    @Schema(description = "回复用户昵称")
    private String replyUserNickName;

    /**
     * 回复记录id
     */
    @Schema(description = "回复记录id")
    private Long replyId;

    /**
     * siteId
     */
    @Schema(description = "siteId")
    private Long siteId;
}