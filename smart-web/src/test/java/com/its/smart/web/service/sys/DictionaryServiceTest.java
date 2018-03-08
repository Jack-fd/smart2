package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.Dictionary;
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
public class DictionaryServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IDictionaryService dictionaryService;

    private static Dictionary dictionary;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        dictionary = new Dictionary();
        dictionary.setDisplayName("测试数据_" + localDateTimeFormat);
        dictionary.setMemo("测试数据_" + localDateTimeFormat);
        dictionary.setIsTest(SmartConsts.DataTestType.TEST);
        dictionary.setSerialNumber(1);
        dictionary.setType("type");
        dictionary.setValue("value");
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(dictionaryService.insert(dictionary));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(dictionaryService.update(dictionary, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(dictionaryService.selectById(dictionary.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(dictionaryService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(dictionaryService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(dictionaryService.deleteById(dictionary.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}