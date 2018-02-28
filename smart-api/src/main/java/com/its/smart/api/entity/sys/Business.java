package com.its.smart.api.entity.sys;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 企业表
 * </p>
 *
 * @author MQ
 * @since 2018-02-27
 */
@TableName("t_business")
@Data
public class Business extends Model<Business> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(type = IdType.UUID)
    private String id;
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
     * 备注
     */
    private String memo;
    /**
     * 是否自定义
     */
    @TableField("is_custom")
    private Integer isCustom;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
