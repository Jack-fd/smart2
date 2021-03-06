package com.its.smart.web.service.sys;

import com.baomidou.mybatisplus.plugins.Page;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.api.consts.SmartConsts;
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
public class UserServiceTest extends AbstractTestNGSpringContextTests implements BaseServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBusinessService businessService;

    private User user;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        user = new User();
        user.setDisplayName("测试数据_" + localDateTimeFormat);
        user.setName(PinyinHelper.convertToPinyinString(user.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        user.setMemo("测试数据_" + localDateTimeFormat);
        user.setIsTest(SmartConsts.DataTestType.TEST);
        user.setAccount("admin");
        user.setPassword("admin");
        user.setBusinessId("3e664b4f1d5d40adb48b569f257e3a20");
        user.setEmail("email");
        user.setIcon("icon");
        user.setPhone("123432432");
        user.setSex(SmartConsts.UserSex.MALE);
        user.setStatus(SmartConsts.UserStatusType.ENABLE);
    }

    @Test
    @Override
    public void testCreate() {
        Assert.assertTrue(userService.insert(user));
    }

    @Test(dependsOnMethods = {"testCreate"})
    @Override
    public void testUpdate() {
        Assert.assertTrue(userService.update(user, null));
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testFindId() {
        Assert.assertNotNull(userService.selectById(user.getId()));
    }

    @Test(dependsOnMethods = {"testFindId"})
    @Override
    public void testList() {
        Assert.assertNotNull(userService.selectList(null));
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        Assert.assertNotNull(userService.selectPage(new Page<>(0, 10)));
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        Assert.assertTrue(userService.deleteById(user.getId()));
    }

//    @Test(dependsOnMethods = {"testDelete"})
//    @Override
//    public void testDeleteTest() {
//        Map<String, Object> map = Maps.newHashMap();
//        map.put("is_test", SmartConsts.DataTestType.TEST);
//        Assert.assertTrue(userService.deleteByMap(map));
//    }
}