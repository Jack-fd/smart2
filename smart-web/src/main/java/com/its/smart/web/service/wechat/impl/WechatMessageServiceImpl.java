package com.its.smart.web.service.wechat.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.wechat.WechatMessage;
import com.its.smart.web.mapper.wechat.WechatMessageMapper;
import com.its.smart.web.service.wechat.IWechatMessageService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信消息 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class WechatMessageServiceImpl extends ServiceImpl<WechatMessageMapper, WechatMessage> implements IWechatMessageService {

}
