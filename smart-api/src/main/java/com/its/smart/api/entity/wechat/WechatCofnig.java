package com.its.smart.api.entity.wechat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * relax微信用用配置
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("wechat_cofnig")
public class WechatCofnig extends IdEntity<WechatCofnig> {

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
     * web地址
     */
    @TableField("web_url")
    private String webUrl;

    /**
     * 数据地址
     */
    @TableField("data_url")
    private String dataUrl;

    /**
     * 微信类型
     */
    @TableField("wechat_type")
    private String wechatType;

    /**
     * 企业号的corpid,服务号appid
     */
    @TableField("corpid_appid")
    private String corpidAppid;

    /**
     * 微信密钥
     */
    private String secret;

    /**
     * 微信应用编号
     */
    @TableField("wechat_appid")
    private Integer wechatAppid;

    /**
     * 应用系统账号
     */
    @TableField("applicaion_account")
    private String applicaionAccount;

    /**
     * 应用系统密码
     */
    @TableField("applicaion_password")
    private String applicaionPassword;

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
