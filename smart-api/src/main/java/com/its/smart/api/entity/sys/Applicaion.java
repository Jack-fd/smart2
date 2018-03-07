package com.its.smart.api.entity.sys;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * <p>
 * 系统应用管理
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Data
@TableName("sys_applicaion")
public class Applicaion extends SysEntity<Applicaion> {

    /**
     * 备注
     */
    private String memo;
    /**
     * 是否测试项目
     */
    @TableField("is_test_project")
    private Integer isTestProject;
    /**
     * 测试到期时间
     */
    @TableField("test_close_time")
    private Date testCloseTime;
    /**
     * 系统类型，relax、rmc、bmc
     */
    @TableField("system_type")
    private String systemType;
    /**
     * 企业编号
     */
    @TableField("business_id")
    private String businessId;

}
