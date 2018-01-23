package com.its.smart.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 搜索条件
 *
 * @author mq
 */
@Data
@AllArgsConstructor
@Builder
public class SearchFilter implements Serializable {

    public String fieldName;

    public Object value;

    public SearchFilter.Operator operator;

    public static enum Operator {

        /**
         * 相等
         */
        EQ,

        /**
         * 模糊
         */
        LIKE,

        /**
         * 大于
         */
        GT,

        /**
         * 小于
         */
        LT,

        /**
         * 大于等于
         */
        GTE,

        /**
         * 小于等于
         */
        LTE,

        /**
         * 不等于
         */
        NOT_EQ;
    }
}
