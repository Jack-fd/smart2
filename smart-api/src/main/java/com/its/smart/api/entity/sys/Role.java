package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 系统角色表
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_role")
public class Role extends SysEntity<Role> {

    /**
     * 名称
     */
    private String name;
    /**
     * 显示名称
     */
    @TableField("display_name")
    private String displayName;

    /**
     * 备注
     */
    private String memo;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否系统数据
     */
    @TableField("is_sys")
    private Integer isSys;
}
