package com.its.smart.web.repository;

import java.util.List;
import java.util.Map;

/**
 * 基础Dao(还需在XML文件里，有对应的SQL语句)
 *
 * @param <T> 参数泛型
 * @author MQ
 */
public interface BaseDao<T> {

    void save(T t);

    void saveBatch(List<T> list);

    int update(T t);

    int deleteBatch(Object[] id);

    T queryObject(String id);

    List<T> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    int queryTotal();
}
