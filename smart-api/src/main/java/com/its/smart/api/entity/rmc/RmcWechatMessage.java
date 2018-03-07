package com.its.smart.api.entity.rmc;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * RMC消息采集
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("rmc_wechat_message")
public class RmcWechatMessage extends IdEntity<RmcWechatMessage> {

    /**
     * 消息唯一计算方法
     */
    @TableField("unique_message")
    private String uniqueMessage;
    /**
     * 状态
     */
    private String status;
    /**
     * RMC消息编号
     */
    private Integer rmcid;
    /**
     * 工单编号
     */
    @TableField("requ_no")
    private String requNo;
    /**
     * 电话号码
     */
    @TableField("mobile_no")
    private String mobileNo;
    /**
     * openID
     */
    @TableField("opend_id")
    private String opendId;
    /**
     * 用户编号
     */
    @TableField("user_id")
    private String userId;
    /**
     * RMC消息产生时间
     */
    private Integer seconds;
    /**
     * RMC消息
     */
    private String message;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("modify_time")
    private Date modifyTime;
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
