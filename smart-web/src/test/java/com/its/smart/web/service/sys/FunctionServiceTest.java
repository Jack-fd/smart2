package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.Function;
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
public class FunctionServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IFunctionService functionService;

    private static Function function;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        function = new Function();
        function.setDisplayName("测试数据_" + localDateTimeFormat);
        function.setName(PinyinHelper.convertToPinyinString(function.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        function.setMemo("测试数据_" + localDateTimeFormat);
        function.setIsTest(SmartConsts.DataTestType.TEST);
        function.setRelation("relation");
        function.setUrl("url");
        function.setIcon("icon");
        function.setStatus(SmartConsts.UserStatusType.ENABLE);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(functionService.insert(function));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(functionService.update(function, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(functionService.selectById(function.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(functionService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(functionService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(functionService.deleteById(function.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}