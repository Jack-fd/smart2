package com.its.smart.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.its.smart.SmartApplication;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Role;
import com.its.smart.api.entity.sys.User;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.collections.Maps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @author mq
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class RoleControllerTest extends AbstractTestNGSpringContextTests implements BaseControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Role role;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        role = new Role();
        role.setDisplayName("测试数据_" + localDateTimeFormat);
        role.setMemo("测试数据_" + localDateTimeFormat);
        role.setIsTest(SmartConsts.DataTestType.TEST);
        role.setName(PinyinHelper.convertToPinyinString(role.getDisplayName(), ",", PinyinFormat.WITHOUT_TONE));
        role.setStatus(SmartConsts.RoleStatusType.ENABLE);
    }

    @Test
    @Override
    public void testCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(role), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/roles", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        String json = JSON.toJSONString(result.getBody().getData());
        role = JSON.parseObject(json, Role.class);
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testUpdate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.error(role.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(role), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/roles", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testDetail() {
        Map<String, String> multiValueMap = Maps.newHashMap();
        multiValueMap.put("id", role.getId());
        R r = testRestTemplate.getForObject("/api/admin/roles/{id}", R.class, multiValueMap);
        Assert.assertEquals(r.getErrorCode(), 0);
        Assert.assertNotNull(r.getData());
        log.debug("detail:{}", r.getData());
    }

    @Test(dependsOnMethods = {"testDetail"})
    @Override
    public void testList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>("{}", headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/roles/list", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testList"})
    @Override
    public void testPage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        PageSearch pageSearch = new PageSearch();
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(pageSearch), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/roles/page", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testPage"})
    @Override
    public void testDelete() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        List<String> deleted = Lists.newArrayList(role.getId());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(deleted), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/roles", HttpMethod.DELETE, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

}

