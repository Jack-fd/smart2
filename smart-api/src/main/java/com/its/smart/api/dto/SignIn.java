package com.its.smart.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户登录
 * @author mq
 */
@Getter
@Setter
@ToString
public class SignIn implements Serializable {

    private String name;

    private String password;
}
