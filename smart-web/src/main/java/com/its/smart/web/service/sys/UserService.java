package com.its.smart.web.service.sys;



import com.its.smart.api.entity.sys.User;

import java.util.List;
import java.util.Map;

/**
 * 系统用户服务接口
 *
 * @author MQ
 */
public interface UserService {

    User queryObject(String id);

    List<User> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(User user);

    void update(User user);

    void deleteBatch(String[] ids);
}
