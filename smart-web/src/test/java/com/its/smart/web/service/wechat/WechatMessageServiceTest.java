package com.its.smart.web.service.wechat;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.wechat.WechatMessage;
import com.its.smart.web.service.sys.BaseServiceTest;
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
public class WechatMessageServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IWechatMessageService wechatMessageService;

    private static WechatMessage wechatMessage;

    @BeforeTest
    @Override
    public void initData() {
        wechatMessage = new WechatMessage();
        wechatMessage.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        wechatMessage.setMessage("message");
        wechatMessage.setReceiveTime(new Date());
        wechatMessage.setSendTime(new Date());
        wechatMessage.setSystemType(SmartConsts.ApplicationSystemType.RELAX);
        wechatMessage.setWechatErrorCode(11111111L);
        wechatMessage.setWechatErrorMsg("errormsg");
        wechatMessage.setWechatMsgId(2222222L);
        wechatMessage.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(wechatMessageService.insert(wechatMessage));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(wechatMessageService.update(wechatMessage, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(wechatMessageService.selectById(wechatMessage.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(wechatMessageService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(wechatMessageService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(wechatMessageService.deleteById(wechatMessage.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}