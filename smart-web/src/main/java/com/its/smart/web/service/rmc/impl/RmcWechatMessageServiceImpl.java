package com.its.smart.web.service.rmc.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.rmc.RmcWechatMessage;
import com.its.smart.web.mapper.rmc.RmcWechatMessageMapper;
import com.its.smart.web.service.rmc.IRmcWechatMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * RMC消息采集 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class RmcWechatMessageServiceImpl extends ServiceImpl<RmcWechatMessageMapper, RmcWechatMessage> implements IRmcWechatMessageService {

}
