package com.its.smart.web.service.sys.impl;

import com.its.smart.api.entity.sys.Business;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.web.repository.sys.BusinessMapper;
import com.its.smart.web.service.sys.IBusinessService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 企业表 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-02-27
 */
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business> implements IBusinessService {

}
