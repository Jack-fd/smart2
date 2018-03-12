package com.its.smart.web.service.wechat;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.wechat.WechatCofnig;
import com.its.smart.web.service.sys.BaseServiceTest;
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
public class WechatCofnigServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IWechatCofnigService wechatCofnigService;

    private static WechatCofnig wechatCofnig;

    @BeforeTest
    @Override
    public void initData() {
        wechatCofnig = new WechatCofnig();
        wechatCofnig.setApplicaionAccount("account");
        wechatCofnig.setApplicaionPassword("password");
        wechatCofnig.setCorpidAppid("corpid");
        wechatCofnig.setDisplayName("测试数据");
        wechatCofnig.setDataUrl("http://www.ruijie.com.cn");
        wechatCofnig.setName(PinyinHelper.convertToPinyinString(wechatCofnig.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        wechatCofnig.setMemo("测试数据");
        wechatCofnig.setSecret("secret");
        wechatCofnig.setWebUrl("weburl");
        wechatCofnig.setWechatAppid(1000001);
        wechatCofnig.setWechatType(SmartConsts.WechatType.MP);
        wechatCofnig.setApplicaionId("e2a3462f37d348bd93b3ed1d1fcb10bf");
        wechatCofnig.setBusinessId("3e664b4f1d5d40adb48b569f257e3a20");
        wechatCofnig.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(wechatCofnigService.insert(wechatCofnig));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(wechatCofnigService.update(wechatCofnig, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(wechatCofnigService.selectById(wechatCofnig.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(wechatCofnigService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(wechatCofnigService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(wechatCofnigService.deleteById(wechatCofnig.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}