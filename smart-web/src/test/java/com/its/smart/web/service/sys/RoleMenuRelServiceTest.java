package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.RoleMenuRel;
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
public class RoleMenuRelServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IRoleMenuRelService roleFunctionRelService;

    private static RoleMenuRel roleMenuRel;

    @BeforeTest
    @Override
    public void initData() {
        roleMenuRel = new RoleMenuRel();
        roleMenuRel.setMenuId("fefbecedd0b74285b95cd5c66e8b2953");
        roleMenuRel.setRoleId("285f392eb2ad42c887d4640644d4387f");
        roleMenuRel.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(roleFunctionRelService.insert(roleMenuRel));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(roleFunctionRelService.update(roleMenuRel, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(roleFunctionRelService.selectById(roleMenuRel.getId()));
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
        Assert.assertTrue(roleFunctionRelService.deleteById(roleMenuRel.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}