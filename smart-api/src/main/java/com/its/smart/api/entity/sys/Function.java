package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_function")
public class Function extends SysEntity<Function> {

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
     * 图标
     */
    private String icon;
    /**
     * 地址
     */
    private String url;
    /**
     * 关联权限
     */
    private String relation;
    /**
     * 排序
     */
    @TableField("serial_number")
    private Integer serialNumber;

}
