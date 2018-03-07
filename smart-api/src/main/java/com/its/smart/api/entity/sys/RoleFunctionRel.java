package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 系统角色与菜单
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_role_function_rel")
public class RoleFunctionRel extends IdEntity<RoleFunctionRel> {

    /**
     * 角色编号
     */
    @TableField("role_id")
    private String roleId;
    /**
     * 菜单编号
     */
    @TableField("function_id")
    private String functionId;
    /**
     * 授权功能
     */
    private String permissions;
    /**
     * 是否系统数据
     */
    @TableField("is_sys")
    private Integer isSys;

}
