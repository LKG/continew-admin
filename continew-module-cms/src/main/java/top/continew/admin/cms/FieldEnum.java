package top.continew.admin.cms;

import lombok.Getter;
import top.continew.starter.core.enums.BaseEnum;

/**
 * @author JiaS
 * @date 2021/1/11
 */
public enum FieldEnum implements FieldCode {

    /**
     *     字段类型 1 单行文本 2 多行文本 3 单选 4 日期 5 数字 6 小数 7 手机  8 文件 9 多选 10 人员
     *     11 附件 12 部门 13 日期时间 14 邮箱 15客户 16 商机 17 联系人 18 地图 19 产品类型 20 合同 21 回款计划  29 图片
     */
    TEXT(1, "text","单行文本"),
    TEXTAREA(2, "textarea","多行文本"),
    SELECT(3, "select","单选"),
    DATE(4, "date","日期"),
    NUMBER(5, "number","数字"),
    FLOAT_NUMBER(6, "float_number","小数"),
    MOBILE(7, "mobile","手机"),
    FILE(8, "file","文件"),
    CHECKBOX(9, "checkbox","多选"),
    USER(10, "user","人员"),
    ATTACHMENT(11,"attachment","附件"),
    STRUCTURE(12, "structure","部门"),
    DATETIME(13, "datetime","日期时间"),
    EMAIL(14, "email","邮件"),
    MAP_ADDRESS(15, "map_address","地图"),
    ADDRESS(16, "address","地址"),
    WEBSITE(17, "website","网址"),
    SINGLE_USER(18, "single_user","单个人员"),
    AREA(19,"area","省市区"),

    BOOLEAN_VALUE(20,"boolean_value","布尔值"),
    PERCENT(21,"percent","百分数"),
    AREA_POSITION(22,"position","地址"),
    CURRENT_POSITION(23,"location","定位"),
    DETAIL_TABLE(24,"detail_table","明细表格"),
    HANDWRITING_SIGN(25,"handwriting_sign","手写签名"),
    DATE_INTERVAL(26,"date_interval","日期区间"),
    OPTIONS_TYPE(27,"options_type","选项字段:逻辑表单、批量编辑、其他"),
    DESC_TEXT(28,"desc_text","描述文字"),
    CALCULATION_FUNCTION(29,"calculation_function","计算函数"),
    RELATE_CAUSE(30,"relate_cause","关联业务"),
    QUOTE_TYPE(31,"quote_type","引用字段"),
    CITY(32,"city","省市"),
    ;

    @Getter
    private Integer type;

    @Getter
    private String formType;

    @Getter
    private String desc;

    FieldEnum() {
    }

    FieldEnum(Integer type, String formType, String desc) {
        this.type = type;
        this.formType = formType;
        this.desc = desc;
    }


    public static FieldEnum parse(Integer type) {
        for (FieldEnum fieldTypeEnum : FieldEnum.values()) {
            if (fieldTypeEnum.getType().equals(type)) {
                return fieldTypeEnum;
            }
        }
        return TEXT;
    }

    public static FieldEnum parse(String formType) {
        for (FieldEnum fieldTypeEnum : FieldEnum.values()) {
            if (fieldTypeEnum.getFormType().equals(formType)) {
                return fieldTypeEnum;
            }
        }
        return TEXT;
    }
}
