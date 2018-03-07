package com.its.smart.web.service.sys.impl;

import com.its.smart.api.entity.sys.User;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.web.mapper.sys.UserMapper;
import com.its.smart.web.service.sys.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户信息 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
