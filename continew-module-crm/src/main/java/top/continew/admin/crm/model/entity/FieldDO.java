package top.continew.admin.crm.model.entity;

import java.io.Serial;

import lombok.Data;

import com.baomidou.mybatisplus.annotation.TableName;

import top.continew.starter.extension.crud.model.entity.BaseDO;

/**
 * 自定义字段实体
 *
 * @author GG
 * @since 2024/12/06 12:13
 */
@Data
@TableName("crm_field")
public class FieldDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 英文标识
     */
    private String fieldName;

    /**
     * 字段名称
     */
    private String name;

    /**
     * 字段类型
     */
    private Integer type;

    /**
     * 标签
     */
    private Integer label;

    /**
     * 字段说明
     */
    private String remark;

    /**
     * 输入提示
     */
    private String inputTips;

    /**
     * 最大长度
     */
    private Integer maxLength;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 是否唯一
     */
    private Integer isUnique;

    /**
     * 是否必填
     */
    private Integer isNull;

    /**
     * 排序
     */
    private Integer sorting;

    /**
     * 如果类型是选项，此处不能为空，多个选项以，隔开
     */
    private String options;

    /**
     * 是否可以删除修改
     */
    private Integer operating;

    /**
     * 是否隐藏
     */
    private Integer isHidden;

    /**
     * 字段来源
     */
    private Integer fieldType;

    /**
     * 只有线索需要，转换客户的自定义字段ID
     */
    private Integer relevant;

    /**
     * 样式百分比%
     */
    private Integer stylePercent;

    /**
     * 精度，允许的最大小数位
     */
    private Integer precisions;

    /**
     * 表单定位
     */
    private String formPosition;

    /**
     * 限制的最大数值
     */
    private String maxNumRestrict;

    /**
     * 限制的最小数值
     */
    private String minNumRestrict;

    /**
     * 表单辅助id，前端生成
     */
    private Integer formAssistId;
}