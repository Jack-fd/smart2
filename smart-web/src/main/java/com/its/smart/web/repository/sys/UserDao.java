package com.its.smart.web.repository.sys;

import com.its.smart.api.entity.sys.User;
import com.its.smart.web.repository.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户数据访问层接口
 */
@Mapper
public interface UserDao extends BaseDao<User> {
}
