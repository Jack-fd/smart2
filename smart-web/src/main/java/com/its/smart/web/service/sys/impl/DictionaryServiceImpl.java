package com.its.smart.web.service.sys.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.its.smart.api.entity.sys.Dictionary;
import com.its.smart.web.mapper.sys.DictionaryMapper;
import com.its.smart.web.service.sys.IDictionaryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据字典表 服务实现类
 * </p>
 *
 * @author MQ
 * @since 2018-03-07
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

}
