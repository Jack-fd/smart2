package com.its.smart.web.service.sys.impl;

import com.its.smart.api.entity.sys.Business;
import com.its.smart.web.repository.sys.BusinessDao;
import com.its.smart.web.service.sys.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessDao businessDao;

    @Override
    public Business queryObject(String id) {
        return businessDao.queryObject(id);
    }

    @Override
    public List<Business> queryList(Map<String, Object> map) {
        return null;
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return 0;
    }

    @Override
    public void save(Business business) {

    }

    @Override
    public void update(Business business) {

    }

    @Override
    public void deleteBatch(String[] ids) {

    }
}
