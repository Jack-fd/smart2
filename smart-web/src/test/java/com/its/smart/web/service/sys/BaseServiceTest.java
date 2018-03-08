package com.its.smart.web.service.sys;

/**
 * 单元测试基础类
 *
 * @author mq
 */
public interface BaseServiceTest {

    /**
     * 创建数据
     */
    void initData();

    /**
     * 创建数据
     */
    void testCreate();

    /**
     * 更新数据
     */
    void testUpdate();

    /**
     * 按数据库编号查询
     */
    void testFindId();

    /**
     * 按条件查询
     */
    void testList();

    /**
     * 分页查询
     */
    void testPage();

    /**
     * 删除数据
     */
    void testDelete();

//    /**
//     * 删除测试数据
//     */
//    void testDeleteTest();
}
