package com.its.smart.web.service.bmc;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.bmc.BmcWechatAccount;
import com.its.smart.api.entity.bmc.BmcWechatRelation;
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
public class BmcWechatRelationServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IBmcWechatRelationService bmcWechatRelationService;

    private static BmcWechatRelation bmcWechatRelation;

    @BeforeTest
    @Override
    public void initData() {
        bmcWechatRelation = new BmcWechatRelation();
        bmcWechatRelation.setOpenid("openid");
        bmcWechatRelation.setAccount("account");
        bmcWechatRelation.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        bmcWechatRelation.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
        bmcWechatRelation.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(bmcWechatRelationService.insert(bmcWechatRelation));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(bmcWechatRelationService.update(bmcWechatRelation, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(bmcWechatRelationService.selectById(bmcWechatRelation.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(bmcWechatRelationService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(bmcWechatRelationService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(bmcWechatRelationService.deleteById(bmcWechatRelation.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}