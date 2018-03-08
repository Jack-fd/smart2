package com.its.smart.web.service.wechat;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.wechat.WechatMessageTemplate;
import com.its.smart.web.service.sys.BaseServiceTest;
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
public class WechatMessageTemplateServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IWechatMessageTemplateService wechatMessageTemplateService;

    private static WechatMessageTemplate wechatMessageTemplate;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        wechatMessageTemplate = new WechatMessageTemplate();
        wechatMessageTemplate.setDisplayName("测试数据_" + localDateTimeFormat);
        wechatMessageTemplate.setMemo("测试数据_" + localDateTimeFormat);
        wechatMessageTemplate.setIsTest(SmartConsts.DataTestType.TEST);
        wechatMessageTemplate.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        wechatMessageTemplate.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
        wechatMessageTemplate.setApplicaionMessageType("email");
        wechatMessageTemplate.setTemplateId("templateid");
        wechatMessageTemplate.setDisplayName("测试数据_" + localDateTimeFormat);
        wechatMessageTemplate.setMemo("测试数据_" + localDateTimeFormat);
        wechatMessageTemplate.setName(PinyinHelper.convertToPinyinString(wechatMessageTemplate.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(wechatMessageTemplateService.insert(wechatMessageTemplate));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(wechatMessageTemplateService.update(wechatMessageTemplate, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(wechatMessageTemplateService.selectById(wechatMessageTemplate.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(wechatMessageTemplateService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(wechatMessageTemplateService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(wechatMessageTemplateService.deleteById(wechatMessageTemplate.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}