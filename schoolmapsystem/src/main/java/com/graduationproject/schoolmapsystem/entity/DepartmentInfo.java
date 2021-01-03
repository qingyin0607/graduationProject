package com.graduationproject.schoolmapsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("department_info")
public class DepartmentInfo extends Model<DepartmentInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 部门id
     */
    @TableId(value = "d_id", type = IdType.AUTO)
    private Integer d_id;

    /**
     * 部门信息
     */
    private String d_infomation;

    /**
     * 部门姓名
     */
    private String d_name;

    /**
     * 联系方式
     */
    private String d_communication;

    /**
     * 照片
     */
    private String d_image;


    public static final String D_ID = "d_id";

    public static final String D_INFOMATION = "d_infomation";

    public static final String D_NAME = "d_name";

    public static final String D_COMMUNICATION = "d_communication";

    public static final String D_IMAGE = "d_image";

    @Override
    protected Serializable pkVal() {
        return this.d_id;
    }

}
