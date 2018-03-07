package com.its.smart.api.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * 实体父类
 *
 * @author mq
 */
public class IdEntity<T extends Model> extends Model<T> {

    /**
     * 主键ID
     */
    @TableId
    private String id;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
