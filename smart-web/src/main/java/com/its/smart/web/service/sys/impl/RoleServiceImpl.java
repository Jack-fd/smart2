package com.its.smart.web.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.sys.Role;
import com.its.smart.web.mapper.sys.RoleMapper;
import com.its.smart.web.service.sys.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统角色表 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
