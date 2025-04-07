package top.continew.admin.cms.model.resp;

import lombok.Data;

import io.swagger.v3.oas.annotations.media.Schema;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;

import top.continew.admin.common.model.resp.BaseDetailResp;

import java.io.Serial;
import java.time.*;

/**
 * 评论详情信息
 *
 * @author gg
 * @since 2025/04/06 10:10
 */
@Data
@ExcelIgnoreUnannotated
@Schema(description = "评论详情信息")
public class CommentDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @Schema(description = "用户id")
    @ExcelProperty(value = "用户id")
    private Long userId;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    @ExcelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 用户头像
     */
    @Schema(description = "用户头像")
    @ExcelProperty(value = "用户头像")
    private String avatar;

    /**
     * 评论内容
     */
    @Schema(description = "评论内容")
    @ExcelProperty(value = "评论内容")
    private String content;

    /**
     * ip地址
     */
    @Schema(description = "ip地址")
    @ExcelProperty(value = "ip地址")
    private String userHost;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String userAgent;

    /**
     * 审核状态
     */
    @Schema(description = "审核状态")
    @ExcelProperty(value = "审核状态")
    private String checkStatus;

    /**
     * 评论主题id
     */
    @Schema(description = "评论主题id")
    @ExcelProperty(value = "评论主题id")
    private Long topicId;

    /**
     * 评论主题类型
     */
    @Schema(description = "评论主题类型")
    @ExcelProperty(value = "评论主题类型")
    private String topicType;

    /**
     * 上一条评论Id
     */
    @Schema(description = "上一条评论Id")
    @ExcelProperty(value = "上一条评论Id")
    private Long parentId;

    /**
     * 是否热评
     */
    @Schema(description = "是否热评")
    @ExcelProperty(value = "是否热评")
    private Integer isHot;

    /**
     * 是否置顶
     */
    @Schema(description = "是否置顶")
    @ExcelProperty(value = "是否置顶")
    private Integer isTop;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String userIpInfo;

    /**
     * 
     */
    @Schema(description = "")
    @ExcelProperty(value = "")
    private String systemHost;

    /**
     * 点赞数量
     */
    @Schema(description = "点赞数量")
    @ExcelProperty(value = "点赞数量")
    private Long rateTimes;

    /**
     * 回复评论用户Id
     */
    @Schema(description = "回复评论用户Id")
    @ExcelProperty(value = "回复评论用户Id")
    private Integer replyUserId;

    /**
     * 回复用户昵称
     */
    @Schema(description = "回复用户昵称")
    @ExcelProperty(value = "回复用户昵称")
    private String replyUserNickName;

    /**
     * 回复记录id
     */
    @Schema(description = "回复记录id")
    @ExcelProperty(value = "回复记录id")
    private Long replyId;

    /**
     * siteId
     */
    @Schema(description = "siteId")
    @ExcelProperty(value = "siteId")
    private Long siteId;
}