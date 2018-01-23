package com.its.smart.web.service.sys;

import com.its.smart.api.entity.sys.Business;

import java.util.List;
import java.util.Map;

/**
 * 企业信息数据访问服务接口
 *
 * @author MQ
 */
public interface BusinessService {

    Business queryObject(String id);

    List<Business> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(Business business);

    void update(Business business);

    void deleteBatch(String[] ids);
}
