package com.its.smart.api.entity.sys;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * 实体父类
 *
 * @author mq
 */
@Data
public class SysEntity<T extends Model> extends IdEntity {


    /**
     * 创建用户
     */
    @TableField("create_user")
    private String createUser;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    /**
     * 是否测试数据
     */
    @TableField("is_test")
    private Integer isTest;
}
