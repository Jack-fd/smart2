package com.its.smart.api.dto;

import lombok.Data;

import java.io.Serializable;


/**
 * 结果对象
 *
 * @param <T> 对象泛型
 * @author MQ
 */
@Data
public class R<T> implements Serializable {
    private static final int OK = 0;
    private static final String M_OK = "成功";

    public static R OK() {
        R r = new R();
        r.setErrorMessage(M_OK);
        r.setErrorCode(OK);
        r.setData("");
        return r;
    }

    public static <T> R OK(T data) {
        R r = new R();
        r.setErrorMessage(M_OK);
        r.setErrorCode(OK);
        r.setData(data);
        return r;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.setErrorMessage(msg);
        r.setErrorCode(500);
        return r;
    }

    private int errorCode;
    private String errorMessage;
    private T data;
}
