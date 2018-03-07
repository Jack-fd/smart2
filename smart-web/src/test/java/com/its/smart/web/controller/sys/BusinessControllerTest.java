package com.its.smart.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.its.smart.SmartApplication;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Business;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class BusinessControllerTest extends AbstractTestNGSpringContextTests implements BaseControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Business business;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        business = new Business();
        business.setDisplayName("测试数据_" + localDateTimeFormat);
        business.setMemo("测试数据_" + localDateTimeFormat);
        business.setIsTest(SmartConsts.DataTestType.TEST);
    }

    @Test
    @Override
    public void testCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(business), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/businesss", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        String json = JSON.toJSONString(result.getBody().getData());
        business = JSON.parseObject(json, Business.class);
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testUpdate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.error(business.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(business), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/businesss", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testDetail() {
        Map<String, String> multiValueMap = Maps.newHashMap();
        multiValueMap.put("id", business.getId());
        R r = testRestTemplate.getForObject("/api/admin/businesss/{id}", R.class, multiValueMap);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/businesss/list", HttpMethod.POST, httpEntity, R.class);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/businesss/page", HttpMethod.POST, httpEntity, R.class);
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
        List<String> deleted = Lists.newArrayList(business.getId());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(deleted), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/businesss", HttpMethod.DELETE, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

}

