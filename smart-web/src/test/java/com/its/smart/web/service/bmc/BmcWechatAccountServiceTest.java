package com.its.smart.web.service.bmc;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.bmc.BmcWechatAccount;
import com.its.smart.api.entity.sys.Applicaion;
import com.its.smart.web.service.bmc.IBmcWechatAccountService;
import com.its.smart.web.service.sys.BaseServiceTest;
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
public class BmcWechatAccountServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IBmcWechatAccountService bmcWechatAccountService;

    private static BmcWechatAccount bmcWechatAccount;

    @BeforeTest
    @Override
    public void initData() {
        bmcWechatAccount = new BmcWechatAccount();
        bmcWechatAccount.setOpenid("openid");
        bmcWechatAccount.setPassword("password");
        bmcWechatAccount.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        bmcWechatAccount.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
        bmcWechatAccount.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(bmcWechatAccountService.insert(bmcWechatAccount));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(bmcWechatAccountService.update(bmcWechatAccount, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(bmcWechatAccountService.selectById(bmcWechatAccount.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(bmcWechatAccountService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(bmcWechatAccountService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(bmcWechatAccountService.deleteById(bmcWechatAccount.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}