package com.its.smart.api.entity.sys;

import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统用户
 *
 * @author MQ
 */
@Data
public class User extends IdEntity implements Serializable {

    /**
     * 账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态
     */
    private Integer status;

    /**
     * 性别
     */
    private String sex;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 英文名称
     */
    private String name;

    /**
     * 名称
     */
    private String displayName;

    /**
     * 修改用户
     */
    private String modifyUser;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 是否自定义
     */
    private Boolean isCustom;

    /**
     * 备注
     */
    private String memo;

    /**
     * 企业编号
     */
    private String businessId;
}
