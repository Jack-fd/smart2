package com.its.smart.web.controller.sys;

/**
 * Controller  测试基础类
 */
public interface BaseControllerTest {

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
    void testDetail();

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

}