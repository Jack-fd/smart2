package com.its.smart.web.controller.rmc;

import com.its.smart.web.shiro.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Test {

    public static void main(String[] args) {
        System.out.println(ShiroUtils.sha256("admin", "4sFibX5frR1ShUu9GzqK"));
//        String salt = RandomStringUtils.randomAlphanumeric(20);
//        System.out.println(salt);
    }
}
