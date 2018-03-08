package com.its.smart.web.service.relax;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.entity.bmc.BmcWechatRelation;
import com.its.smart.api.entity.relax.RelaxWechatCofnig;
import com.its.smart.web.service.bmc.IBmcWechatRelationService;
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
public class RelaxWechatCofnigServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IRelaxWechatCofnigService relaxWechatCofnigService;

    private static RelaxWechatCofnig relaxWechatCofnig;

    @BeforeTest
    @Override
    public void initData() {
        relaxWechatCofnig = new RelaxWechatCofnig();
        relaxWechatCofnig.setApplicaionAccount("account");
        relaxWechatCofnig.setApplicaionPassword("password");
        relaxWechatCofnig.setCorpidAppid("corpid");
        relaxWechatCofnig.setDisplayName("测试数据");
        relaxWechatCofnig.setDataUrl("http://www.ruijie.com.cn");
        relaxWechatCofnig.setName(PinyinHelper.convertToPinyinString(relaxWechatCofnig.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        relaxWechatCofnig.setMemo("测试数据");
        relaxWechatCofnig.setSecret("secret");
        relaxWechatCofnig.setWebUrl("weburl");
        relaxWechatCofnig.setWechatAppid(1000001);
        relaxWechatCofnig.setWechatType(SmartConsts.WechatType.MP);
        relaxWechatCofnig.setApplicaionId("b208f5cd2e104a459b1c02469b801a46");
        relaxWechatCofnig.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
        relaxWechatCofnig.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(relaxWechatCofnigService.insert(relaxWechatCofnig));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(relaxWechatCofnigService.update(relaxWechatCofnig, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(relaxWechatCofnigService.selectById(relaxWechatCofnig.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(relaxWechatCofnigService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(relaxWechatCofnigService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(relaxWechatCofnigService.deleteById(relaxWechatCofnig.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}