package com.its.smart.common.xss;

import com.its.smart.common.exception.SmartSqlException;

/**
 * SQL 过滤
 * @author MQ
 */
public class SqlFilter {
    /**
     * SQL注入过滤
     * @param str  待验证的字符串
     */
    public static String sqlInject(String str){
        if(str.isEmpty()){
            return null;
        }
        //去掉'|"|;|\字符
        str = str.replace( "'", "");
        str = str.replace("\"", "");
        str = str.replace(";", "");
        str = str.replace("\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};

        //判断是否包含非法字符
        for(String keyword : keywords){
            if(str.indexOf(keyword) != -1){
                throw new SmartSqlException("包含非法字符");
            }
        }

        return str;
    }
}
