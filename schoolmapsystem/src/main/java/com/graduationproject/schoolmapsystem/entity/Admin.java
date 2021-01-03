package com.graduationproject.schoolmapsystem.entity;

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
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id字段 自增
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer admin_id;

    /**
     * 管理员名称
     */
    private String admin_name;

    /**
     * 管理员密码
     */
    private String admin_password;

    /**
     * 管理员手机号
     */
    private String admin_phone;

    /**
     * 管理员等级 1-admin,2-user
     */
    private Integer admin_level;


    public static final String ADMIN_ID = "admin_id";

    public static final String ADMIN_NAME = "admin_name";

    public static final String ADMIN_PASSWORD = "admin_password";

    public static final String ADMIN_PHONE = "admin_phone";

    public static final String ADMIN_LEVEL = "admin_level";

    @Override
    protected Serializable pkVal() {
        return this.admin_id;
    }


}
