package com.its.smart.web.service.rmc;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.rmc.RmcWechatMessage;
import com.its.smart.web.service.sys.BaseServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 * @author mq
 */
@SpringBootTest
public class RmcWechatMessageServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IRmcWechatMessageService rmcWechatMessageService;

    private static RmcWechatMessage rmcWechatMessage;

    @BeforeTest
    @Override
    public void initData() {
        rmcWechatMessage = new RmcWechatMessage();
        rmcWechatMessage.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        rmcWechatMessage.setMessage("测试数据");
        rmcWechatMessage.setMobileNo("1827398123");
        rmcWechatMessage.setOpendId("234lkdj23");
        rmcWechatMessage.setRequNo("2323423");
        rmcWechatMessage.setRmcid(234);
        rmcWechatMessage.setStatus("status");
        rmcWechatMessage.setUserId("user");
        rmcWechatMessage.setUniqueMessage(UUID.randomUUID().toString());
        rmcWechatMessage.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
        rmcWechatMessage.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(rmcWechatMessageService.insert(rmcWechatMessage));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(rmcWechatMessageService.update(rmcWechatMessage, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(rmcWechatMessageService.selectById(rmcWechatMessage.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(rmcWechatMessageService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(rmcWechatMessageService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(rmcWechatMessageService.deleteById(rmcWechatMessage.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}