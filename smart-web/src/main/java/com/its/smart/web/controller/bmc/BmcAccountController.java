package com.its.smart.web.controller.bmc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * BMC账号信息验证 前端控制器
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@RestController
@RequestMapping("/api/wx/bmc/account")
public class BmcAccountController {


    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public Object signIn(String userName, String password) {
        return null;
    }
}
