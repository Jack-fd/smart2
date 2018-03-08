package com.its.smart.api.consts;

/**
 * 使用到的常量类.
 *
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

    /**
     * 用户性别
     */
    public static class UserSex {

        /**
         * 男性
         */
        public static final String MALE = "male";

        /**
         * 女性
         */
        public static final String FEMALE = "female";
    }

    /**
     * 用户状态类型
     */
    public static class UserStatusType {

        /**
         * 启用
         */
        public static final Integer ENABLE = 0;

        /**
         * 禁用
         */
        public static final Integer DISABLE = 1;

    }

    /**
     * 角色状态类型
     */
    public static class RoleStatusType {

        /**
         * 启用
         */
        public static final Integer ENABLE = 0;

        /**
         * 禁用
         */
        public static final Integer DISABLE = 1;

    }

    /**
     * 角色状态类型
     */
    public static class ApplicationTestProjectStatus {

        /**
         * 正式项目
         */
        public static final Integer FORMAL = 0;

        /**
         * 演示项目
         */
        public static final Integer DEMO = 1;

    }

    /**
     * 角色状态类型
     */
    public static class ApplicationSystemType {

        /**
         * RELAX
         */
        public static final String RELAX = "RELAX";

        /**
         * BMC
         */
        public static final String BMC = "BMC";

        /**
         * RMC
         */
        public static final String RMC = "RMC";

    }

    /**
     * 微信类型
     */
    public class WechatType {
        /**
         * 公众服务号ß
         */
        public static final String MP = "MP";

        /**
         * 微信企业号
         */
        public static final String WORK = "WOR";
    }
}
