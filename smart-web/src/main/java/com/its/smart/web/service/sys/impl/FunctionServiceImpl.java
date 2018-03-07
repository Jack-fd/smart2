package com.its.smart.web.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.sys.Function;
import com.its.smart.web.mapper.sys.FunctionMapper;
import com.its.smart.web.service.sys.IFunctionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class FunctionServiceImpl extends ServiceImpl<FunctionMapper, Function> implements IFunctionService {

}
