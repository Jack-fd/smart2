package com.its.smart.web.repository.sys;

import com.its.smart.api.entity.sys.Business;
import com.its.smart.web.repository.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 企业信息数据访问接口
 */
@Mapper
public interface BusinessDao extends BaseDao<Business> {
}
