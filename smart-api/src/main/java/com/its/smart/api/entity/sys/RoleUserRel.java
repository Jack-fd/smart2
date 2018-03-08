package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 角色与用户
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_role_user_rel")
public class RoleUserRel extends IdEntity<RoleUserRel> {

    /**
     * 角色编号
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;

    /**
     * 是否系统数据
     */
    @TableField("is_sys")
    private Integer isSys;

    /**
     * 是否测试数据
     */
    @TableField("is_test")
    private Integer isTest;

}
