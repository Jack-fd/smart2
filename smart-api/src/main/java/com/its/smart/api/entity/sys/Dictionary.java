package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 数据字典表
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_dictionary")
public class Dictionary extends SysEntity<Dictionary> {

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
     * 是否系统数据
     */
    @TableField("is_sys")
    private Integer isSys;
    /**
     * 备注
     */
    private String memo;
    /**
     * 值
     */
    private String value;
    /**
     * 字典分类
     */
    private String type;
    /**
     * 排序
     */
    @TableField("serial_number")
    private Integer serialNumber;

}
