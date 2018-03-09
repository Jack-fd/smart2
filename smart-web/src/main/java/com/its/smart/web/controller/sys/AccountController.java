package com.its.smart.web.controller.sys;

import com.its.smart.api.dto.R;
import com.its.smart.api.dto.SignIn;
import com.its.smart.api.entity.sys.User;
import com.its.smart.web.service.sys.IUserService;
import com.its.smart.web.shiro.ShiroUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public R signIn(@RequestBody SignIn signIn) {
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(signIn.getName(), signIn.getPassword());
            subject.login(token);
        } catch (UnknownAccountException e) {
            return R.error(401, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return R.error(401, "账号或密码不正确");
        } catch (LockedAccountException e) {
            return R.error(401, "账号已被锁定,请联系管理员");
        } catch (AuthenticationException e) {
            return R.error(401, "账户验证失败");
        }

        return this.userInfo();
    }

    @RequestMapping(value = "/sign-out", method = RequestMethod.POST)
    public R signOut() {
        Subject subject = ShiroUtils.getSubject();
        subject.logout();
        return R.OK();
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public R userInfo() {
        String userId = ShiroUtils.getUserId();
        User user = userService.selectById(userId);
        return R.OK(user);
    }
}
