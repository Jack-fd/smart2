package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.Applicaion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author mq
 */
@SpringBootTest
public class ApplicationServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IApplicaionService applicaionService;

    private static Applicaion applicaion;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        applicaion = new Applicaion();
        applicaion.setIsTestProject(SmartConsts.ApplicationTestProjectStatus.DEMO);
        applicaion.setMemo("测试数据_" + localDateTimeFormat);
        applicaion.setIsTest(SmartConsts.DataTestType.TEST);
        applicaion.setTestCloseTime(new Date());
        applicaion.setSystemType(SmartConsts.ApplicationSystemType.RELAX);
        applicaion.setBusinessId("3e664b4f1d5d40adb48b569f257e3a20");
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(applicaionService.insert(applicaion));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(applicaionService.update(applicaion, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(applicaionService.selectById(applicaion.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(applicaionService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(applicaionService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(applicaionService.deleteById(applicaion.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}