package com.its.smart.api.entity.wechat;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 微信消息
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("wechat_message")
public class WechatMessage extends IdEntity<WechatMessage> {
    /**
     * 应用类型
     */
    @TableField("system_type")
    private String systemType;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 消息收到时间
     */
    @TableField("receive_time")
    private Date receiveTime;
    /**
     * 发送时间
     */
    @TableField("send_time")
    private Date sendTime;
    /**
     * 微信状态码
     */
    @TableField("wechat_error_code")
    private Long wechatErrorCode;
    /**
     * 微信消息结果
     */
    @TableField("wechat_error_msg")
    private String wechatErrorMsg;
    /**
     * 微信消息编号
     */
    @TableField("wechat_msg_id")
    private Long wechatMsgId;
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
