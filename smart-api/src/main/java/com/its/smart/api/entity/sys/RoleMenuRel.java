package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

/**
 * <p>
 * 系统角色与菜单
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_role_menu_rel")
public class RoleMenuRel extends IdEntity<RoleMenuRel> {

    /**
     * 角色编号
     */
    @TableField("role_id")
    private String roleId;

    /**
     * 菜单编号
     */
    @TableField("menu_id")
    private String menuId;

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
