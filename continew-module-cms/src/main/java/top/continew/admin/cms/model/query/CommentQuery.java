package top.continew.admin.cms.model.query;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import top.continew.starter.data.core.annotation.Query;
import top.continew.starter.data.core.enums.QueryType;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 评论查询条件
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Data
@Schema(description = "评论查询条件")
public class CommentQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @Query(type = QueryType.BETWEEN)
    private LocalDateTime[] createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @Query(type = QueryType.EQ)
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @Query(type = QueryType.EQ)
    private Long userId;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    @Query(type = QueryType.EQ)
    private String nickName;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @Query(type = QueryType.EQ)
    private String checkStatus;

    /**
     * 评论主题id
     */
    @Schema(description = "评论主题id")
    @Query(type = QueryType.EQ)
    private Long topicId;

    /**
     * 上一条评论Id
     */
    @Schema(description = "上一条评论Id")
    @Query(type = QueryType.EQ)
    private Long parentId;

    /**
     * 是否热评
     */
    @Schema(description = "是否热评")
    @Query(type = QueryType.EQ)
    private Integer isHot;

    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    @Query(type = QueryType.EQ)
    private Integer isTop;

    /**
     * 点赞数量
     */
    @Schema(description = "点赞数量")
    @Query(type = QueryType.EQ)
    private Long rateTimes;

    /**
     * 回复评论用户Id
     */
    @Schema(description = "回复评论用户Id")
    @Query(type = QueryType.EQ)
    private Integer replyUserId;

    /**
     * 回复用户昵称
     */
    @Schema(description = "回复用户昵称")
    @Query(type = QueryType.EQ)
    private String replyUserNickName;

    /**
     * 回复记录id
     */
    @Schema(description = "回复记录id")
    @Query(type = QueryType.EQ)
    private Long replyId;
}