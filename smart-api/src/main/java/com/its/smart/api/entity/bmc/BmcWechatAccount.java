package com.its.smart.api.entity.bmc;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * BMC账号信息
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("bmc_wechat_account")
public class BmcWechatAccount extends IdEntity<BmcWechatAccount> {

    /**
     * 微信账号
     */
    private String openid;
    /**
     * BMC账号
     */
    private String account;
    /**
     * BMC密码
     */
    private String password;
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

    /**
     * 是否测试数据
     */
    @TableField("is_test")
    private Integer isTest;
}
