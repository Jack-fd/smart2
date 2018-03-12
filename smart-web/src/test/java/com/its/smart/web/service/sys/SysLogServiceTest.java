package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.entity.sys.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;

/**
 * @author mq
 */
@SpringBootTest
public class SysLogServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private ISysLogService sysLogService;

    private SysLog sysLog;

    @BeforeTest
    @Override
    public void initData() {
        sysLog = new SysLog();
        sysLog.setCreateDate(new Date());
        sysLog.setIp("ip");
        sysLog.setOperation("aaa");
        sysLog.setParams("{params}");
        sysLog.setTime(11L);
        sysLog.setUsername("test");
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(sysLogService.insert(sysLog));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(sysLogService.update(sysLog, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(sysLogService.selectById(sysLog.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(sysLogService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(sysLogService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(sysLogService.deleteById(sysLog.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}