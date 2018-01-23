package com.its.smart.web.service.sys.impl;

import com.its.smart.api.entity.sys.User;
import com.its.smart.web.repository.sys.UserDao;
import com.its.smart.web.service.sys.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 系统用户服务接口实现
 *
 * @author MQ
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User queryObject(String id) {
        return userDao.queryObject(id);
    }

    @Override
    public List<User> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void deleteBatch(String[] ids) {

    }
}
