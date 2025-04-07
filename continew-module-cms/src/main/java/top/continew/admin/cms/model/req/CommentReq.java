package top.continew.admin.cms.model.req;

import jakarta.validation.constraints.*;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;
import java.time.*;

/**
 * 创建或修改评论参数
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Data
@Schema(description = "创建或修改评论参数")
public class CommentReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 创建时间
     */
    @Schema(description = "创建时间")
    @NotNull(message = "创建时间不能为空")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @Schema(description = "修改时间")
    @NotNull(message = "修改时间不能为空")
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @NotNull(message = "用户id不能为空")
    private Long userId;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    @NotBlank(message = "用户昵称不能为空")
    @Length(max = 128, message = "用户昵称长度不能超过 {max} 个字符")
    private String nickName;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @NotBlank(message = "审核状态不能为空")
    @Length(max = 64, message = "审核状态长度不能超过 {max} 个字符")
    private String checkStatus;

    /**
     * 评论主题id
     */
    @Schema(description = "评论主题id")
    @NotNull(message = "评论主题id不能为空")
    private Long topicId;

    /**
     * 上一条评论Id
     */
    @Schema(description = "上一条评论Id")
    @NotNull(message = "上一条评论Id不能为空")
    private Long parentId;

    /**
     * 是否热评
     */
    @Schema(description = "是否热评")
    @NotNull(message = "是否热评不能为空")
    private Integer isHot;

    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    @NotNull(message = "是否置顶不能为空")
    private Integer isTop;

    /**
     * 点赞数量
     */
    @Schema(description = "点赞数量")
    @NotNull(message = "点赞数量不能为空")
    private Long rateTimes;

    /**
     * 回复评论用户Id
     */
    @Schema(description = "回复评论用户Id")
    @NotNull(message = "回复评论用户Id不能为空")
    private Integer replyUserId;

    /**
     * 回复用户昵称
     */
    @Schema(description = "回复用户昵称")
    @NotBlank(message = "回复用户昵称不能为空")
    @Length(max = 128, message = "回复用户昵称长度不能超过 {max} 个字符")
    private String replyUserNickName;

    /**
     * 回复记录id
     */
    @Schema(description = "回复记录id")
    @NotNull(message = "回复记录id不能为空")
    private Long replyId;
}