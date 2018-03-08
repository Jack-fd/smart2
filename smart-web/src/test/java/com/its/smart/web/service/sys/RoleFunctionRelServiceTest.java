package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.RoleFunctionRel;
import com.its.smart.api.entity.sys.RoleUserRel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author mq
 */
@SpringBootTest
public class RoleFunctionRelServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IRoleFunctionRelService roleFunctionRelService;

    private static RoleFunctionRel roleFunctionRel;

    @BeforeTest
    @Override
    public void initData() {
        roleFunctionRel = new RoleFunctionRel();
        roleFunctionRel.setFunctionId("142c4c59c8314be6942976fba6ec7cfc");
        roleFunctionRel.setRoleId("00759bf8e86c4ec3b7b97c0ddde09850");
        roleFunctionRel.setPermissions("12");
        roleFunctionRel.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(roleFunctionRelService.insert(roleFunctionRel));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(roleFunctionRelService.update(roleFunctionRel, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(roleFunctionRelService.selectById(roleFunctionRel.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(roleFunctionRelService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(roleFunctionRelService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(roleFunctionRelService.deleteById(roleFunctionRel.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}