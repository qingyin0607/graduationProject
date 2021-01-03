package com.graduationproject.schoolmapsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xiaoyiquan&panzhengyang
 * @since 2021-01-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("universities_info")
public class UniversitiesInfo extends Model<UniversitiesInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 学校名称
     */
    private String universities_name;

    /**
     * 学校简介
     */
    private String universities_introduction;

    /**
     * 校训
     */
    private String universities_schoolmotto;

    /**
     * 学校地址
     */
    private String universities_address;

    /**
     * 学校电话
     */
    private String universities_phone;

    /**
     * 学校传真
     */
    private String universities_fax;

    /**
     * 学校logo(图片地址)
     */
    private String universities_logo;


    public static final String UNIVERSITIES_NAME = "universities_name";

    public static final String UNIVERSITIES_INTRODUCTION = "universities_introduction";

    public static final String UNIVERSITIES_SCHOOLMOTTO = "universities_schoolmotto";

    public static final String UNIVERSITIES_ADDRESS = "universities_address";

    public static final String UNIVERSITIES_PHONE = "universities_phone";

    public static final String UNIVERSITIES_FAX = "universities_fax";

    public static final String UNIVERSITIES_LOGO = "universities_logo";

    @Override
    protected Serializable pkVal() {
        return this.universities_name;
    }

}
