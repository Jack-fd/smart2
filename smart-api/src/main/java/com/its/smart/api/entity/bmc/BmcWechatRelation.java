package com.its.smart.api.entity.bmc;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * BMC用户关系
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("bmc_wechat_relation")
public class BmcWechatRelation extends IdEntity<BmcWechatRelation> {

    /**
     * 微信账号
     */
    private String openid;
    /**
     * BMC APP 账号
     */
    private String account;
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
