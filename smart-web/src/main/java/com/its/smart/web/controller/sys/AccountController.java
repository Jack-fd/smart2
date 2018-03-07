package com.its.smart.web.controller.sys;

import com.its.smart.api.dto.R;
import com.its.smart.api.dto.SignIn;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户登陆验证 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/admin/accounts")
public class AccountController {

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public R signIn(SignIn signIn, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @RequestMapping(value = "/sign-out", method = RequestMethod.POST)
    public R signOut() {
        return null;
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public R userInfo() {
        return null;
    }
}
