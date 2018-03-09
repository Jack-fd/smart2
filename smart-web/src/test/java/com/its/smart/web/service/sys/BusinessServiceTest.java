package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.sys.Business;
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
public class BusinessServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IBusinessService businessService;

    private static Business business;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        business = new Business();
        business.setDisplayName("测试数据_" + localDateTimeFormat);
        business.setName(PinyinHelper.getShortPinyin(business.getDisplayName()));
        business.setMemo("测试数据_" + localDateTimeFormat);
        business.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(businessService.insert(business));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Wrapper wrapper = new Wrapper() {

            @Override
            public String getSqlSegment() {
                return " WHERE id = '" + business.getId() + "'";
            }
        };
        Assert.assertTrue(businessService.update(business, wrapper));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(businessService.selectById(business.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(businessService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(businessService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(businessService.deleteById(business.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(businessService.deleteByMap(map));
//    }
}