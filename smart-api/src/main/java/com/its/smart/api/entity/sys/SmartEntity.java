package com.its.smart.api.entity.sys;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体父类
 */
@Data
public class SmartEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId
    private String id;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    /**
     * 创建用户
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改用户
     */
    @TableField("modify_user")
    private String modifyUser;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;

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
