package com.its.smart.api.entity.wechat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 微信消息模板
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("wechat_message_template")
public class WechatMessageTemplate extends IdEntity<WechatMessageTemplate> {

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
     * 是否测试数据
     */
    @TableField("is_test")
    private Integer isTest;
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
     * 模板编号
     */
    @TableField("template_id")
    private String templateId;
    /**
     * 应用消息类型
     */
    @TableField("applicaion_message_type")
    private String applicaionMessageType;
    /**
     * 应用编号
     */
    @TableField("applicaion_id")
    private String applicaionId;
    /**
     * 企业编号
     */
    @TableField("business_id")
    private String businessId;

}
