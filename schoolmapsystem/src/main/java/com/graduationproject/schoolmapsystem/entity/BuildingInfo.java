package com.graduationproject.schoolmapsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
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
@TableName("building_info")
public class BuildingInfo extends Model<BuildingInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 校内建筑id 自增
     */
    @TableId(value = "building_id", type = IdType.AUTO)
    private Integer building_id;

    /**
     * 建筑名称、别名
     */
    private String building_name;

    /**
     * 建筑类型 （1-饮食，2-教学与实训，3-办公，4-体育，5-生活，6-洗手间
     */
    private Integer building_type;

    /**
     * 建筑所属区域
     */
    private String building_area;

    /**
     * 建筑内含学校部门-与学校部门信息表关联
     */
    private Integer building_department;

    /**
     * 建筑描述信息
     */
    private String building_info;

    /**
     * 建筑开放时间
     */
    private Date building_opentime;

    /**
     * 建筑关闭时间
     */
    private Date building_closingtime;

    /**
     * 建筑图片 （存放地址）
     */
    private String building_image;


    public static final String BUILDING_ID = "building_id";

    public static final String BUILDING_NAME = "building_name";

    public static final String BUILDING_TYPE = "building_type";

    public static final String BUILDING_AREA = "building_area";

    public static final String BUILDING_DEPARTMENT = "building_department";

    public static final String BUILDING_INFO = "building_info";

    public static final String BUILDING_OPENTIME = "building_opentime";

    public static final String BUILDING_CLOSINGTIME = "building_closingtime";

    public static final String BUILDING_IMAGE = "building_image";

    @Override
    protected Serializable pkVal() {
        return this.building_id;
    }

}
