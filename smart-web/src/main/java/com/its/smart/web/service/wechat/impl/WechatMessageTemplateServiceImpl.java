package com.its.smart.web.service.wechat.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.wechat.WechatMessageTemplate;
import com.its.smart.web.mapper.wechat.WechatMessageTemplateMapper;
import com.its.smart.web.service.wechat.IWechatMessageTemplateService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 微信消息模板 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class WechatMessageTemplateServiceImpl extends ServiceImpl<WechatMessageTemplateMapper, WechatMessageTemplate> implements IWechatMessageTemplateService {

}
