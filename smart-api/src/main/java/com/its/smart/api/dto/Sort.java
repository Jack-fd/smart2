package com.its.smart.api.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 排序字段
 * @author mq
 */
@Data
public class Sort implements Serializable {

    public String fieldName;

    public String direction;
}

