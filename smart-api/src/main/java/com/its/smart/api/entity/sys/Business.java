package com.its.smart.api.entity.sys;

import com.its.smart.api.entity.IdEntity;
import lombok.Data;

import java.util.Date;

/**
 * 企业信息
 *
 * @author MQ
 */
@Data
public class Business extends IdEntity {

    /**
     * 名称
     */
    private String name;

    /**
     * 显示名称
     */
    private String displayName;

    /**
     * 创建用户
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改用户
     */
    private String modifyUser;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 备注
     */
    private String memo;

    /**
     * 是否自定义
     */
    private Boolean isCustom;
}
