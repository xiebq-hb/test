package com.duker.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author xiebq
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_data")
public class UserDataEntity extends Model<UserDataEntity> {

    private static final long serialVersionUID=1L;

    /**
     * 用户主键
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * title
     */
    @TableField(value = "title")
    private String title;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField(value = "user_password")
    private String userPassword;

    /**
     * 注册时间
     */
    @TableField(value = "user_regdate")
    private Date userRegdate;

    /**
     * 最后登陆时间
     */
    @TableField(value = "user_lastlogin")
    private Date userLastlogin;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}
