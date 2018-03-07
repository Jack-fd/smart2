package com.its.smart.web.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.sys.Business;
import com.its.smart.web.mapper.sys.BusinessMapper;
import com.its.smart.web.service.sys.IBusinessService;
import org.springframework.stereotype.Service;

/**
 * Business 表数据服务层接口实现类
 *
 * @author mq
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {


}