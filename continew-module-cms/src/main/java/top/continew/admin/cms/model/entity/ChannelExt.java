package top.continew.admin.cms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;
import top.continew.admin.common.model.entity.BaseDO;

import java.io.Serializable;

/**
 * 栏目扩展数据实体类
 *
 * @author PONY
 */
@Schema(name = "Channel.ChannelExt")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties("handler")
@Data
@TableName("cms_channel_ext")
public class ChannelExt extends BaseDO implements Serializable {


    /**
     * 静态页文件
     */
    @Length(max = 255)
    @Nullable
    @Schema(description="静态页文件")
    private String staticFile;

    /**
     * 手机端静态页文件
     */
    @Length(max = 255)
    @Nullable
    @Schema(description="手机端静态页文件")
    private String mobileStaticFile;

    /**
     * 编辑器类型(1:富文本编辑器,2:Markdown编辑器)
     */
    @NotNull
    @Schema(description="编辑器类型(1:富文本编辑器,2:Markdown编辑器)")
    private Short editorType = 1;

    /**
     * 正文
     */
    @Nullable
    @Schema(description="正文")
    private String text;

    /**
     * Markdown正文
     */
    @Nullable
    @Schema(description="Markdown正文")
    private String markdown;

}