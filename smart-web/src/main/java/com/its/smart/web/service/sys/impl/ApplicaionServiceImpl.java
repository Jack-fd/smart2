package com.its.smart.web.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.sys.Applicaion;
import com.its.smart.web.mapper.sys.ApplicaionMapper;
import com.its.smart.web.service.sys.IApplicaionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统应用管理 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class ApplicaionServiceImpl extends ServiceImpl<ApplicaionMapper, Applicaion> implements IApplicaionService {

}
