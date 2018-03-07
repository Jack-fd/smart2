package com.its.smart.api.consts;

/**
 * 使用到的常量类.
 * @author mq
 */
public class SmartConsts {

    /**
     * 区分用户数据与系统数据数据类型
     */
    public static class DataSysType {

        /**
         * 用户数据
         */
        public static final Integer USER = 0;

        /**
         * 系统数据
         */
        public static final Integer SYSTEM = 1;

    }

    /**
     * 区分测试数据与普通数据
     */
    public static class DataTestType {

        /**
         * 非测试数据
         */
        public static final Integer NOTTEST = 0;

        /**
         * 测试数据
         */
        public static final Integer TEST = 1;

    }
}
