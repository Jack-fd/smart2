package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 企业表
 * </p>
 *
 * @author MQ
 * @since 2018-02-27
 */
@TableName("sys_business")
@Data
public class Business extends SmartEntity<Business> {

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

}
