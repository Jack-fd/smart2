package com.its.smart.common.Exception;

import lombok.Data;

/**
 * SQL语句错误
 *
 * @author MQ
 */
@Data
public class SmartSqlException extends RuntimeException {

    private String msg;
    private int code = 500;

    public SmartSqlException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public SmartSqlException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public SmartSqlException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public SmartSqlException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}
