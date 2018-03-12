package com.its.smart.web.shiro;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.its.smart.api.entity.sys.Menu;
import com.its.smart.api.entity.sys.RoleMenuRel;
import com.its.smart.api.entity.sys.RoleUserRel;
import com.its.smart.api.entity.sys.User;
import com.its.smart.web.service.sys.IMenuService;
import com.its.smart.web.service.sys.IRoleMenuRelService;
import com.its.smart.web.service.sys.IRoleUserRelService;
import com.its.smart.web.service.sys.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 用户认真
 *
 * @author mq
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleUserRelService roleUserRelService;

    @Autowired
    private IRoleMenuRelService roleMenuRelService;

    @Autowired
    private IMenuService menuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        String userId = user.getId();

        Map<String, Object> map = Maps.newHashMap();
        map.put("user_id", userId);
        List<RoleUserRel> roleUserRelList = roleUserRelService.selectByMap(map);

        List<String> permsList = Lists.newArrayList();
        for (RoleUserRel roleUserRel : roleUserRelList) {
            Map<String, Object> roleMenuRelMap = Maps.newHashMap();
            roleMenuRelMap.put("role_id", roleUserRel.getRoleId());
            List<RoleMenuRel> roleMenuRelList = roleMenuRelService.selectByMap(roleMenuRelMap);
            List<String> menuIds = Lists.newArrayList();
            roleMenuRelList.stream().forEach(roleMenuRel -> menuIds.add(roleMenuRel.getMenuId()));
            List<Menu> menuList = menuService.selectBatchIds(menuIds);
            menuList.stream().forEach(menu -> permsList.add(menu.getPermissions()));
        }

        //用户权限列表
        Set<String> permsSet = new HashSet<>();
        for (String perms : permsList) {
            if (Strings.isNullOrEmpty(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        //查询用户信息
        Map<String, Object> map = Maps.newHashMap();
        map.put("account", token.getUsername());
        User user = null;
        List<User> userList = userService.selectByMap(map);
        if(!userList.isEmpty()) {
            user = userList.get(0);
        }

        //账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return info;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
