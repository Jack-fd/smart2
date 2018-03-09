package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.Menu;
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
public class MenuServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IMenuService functionService;

    private static Menu menu;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        menu = new Menu();
        menu.setDisplayName("数据字典");
        menu.setName("dictionarys");

//        menu.setName(PinyinHelper.convertToPinyinString(menu.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        menu.setMemo("测试数据_" + localDateTimeFormat);
        menu.setIsTest(SmartConsts.DataTestType.TEST);
        menu.setPermissions("permissions");
        menu.setType(1);
        menu.setOrderNum(5);
        menu.setUrl("/dictionary");
        menu.setIcon("icon");
        menu.setStatus(SmartConsts.UserStatusType.ENABLE);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(functionService.insert(menu));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(functionService.update(menu, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(functionService.selectById(menu.getId()));
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
        Assert.assertTrue(functionService.deleteById(menu.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}