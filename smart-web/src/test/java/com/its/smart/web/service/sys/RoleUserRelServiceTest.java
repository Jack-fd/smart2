package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.RoleUserRel;
import com.its.smart.api.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author mq
 */
@SpringBootTest
public class RoleUserRelServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IRoleUserRelService roleUserRelService;

    private static RoleUserRel roleUserRel;

    @BeforeTest
    @Override
    public void initData() {
        roleUserRel = new RoleUserRel();
        roleUserRel.setUserId("f984a6faca39417aaef824029963c9e2");
        roleUserRel.setRoleId("285f392eb2ad42c887d4640644d4387f");
        roleUserRel.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(roleUserRelService.insert(roleUserRel));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(roleUserRelService.update(roleUserRel, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(roleUserRelService.selectById(roleUserRel.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(roleUserRelService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(roleUserRelService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(roleUserRelService.deleteById(roleUserRel.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}