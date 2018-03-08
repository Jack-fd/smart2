package com.its.smart.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.its.smart.SmartApplication;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.Applicaion;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author mq
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class ApplicationControllerTest extends AbstractTestNGSpringContextTests implements BaseControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private Applicaion applicaion;

    @BeforeTest
    @Override
    public void initData() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String localDateTimeFormat = localDateTime.format(dateTimeFormatter);
        applicaion = new Applicaion();
        applicaion.setIsTestProject(SmartConsts.ApplicationTestProjectStatus.DEMO);
        applicaion.setMemo("测试数据_" + localDateTimeFormat);
        applicaion.setIsTest(SmartConsts.DataTestType.TEST);
        applicaion.setTestCloseTime(new Date());
        applicaion.setSystemType(SmartConsts.ApplicationSystemType.RELAX);
        applicaion.setBusinessId("7e2ea371024b4b0e81c7941814b804f8");
    }

    @Test
    @Override
    public void testCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(applicaion), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/applications", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        String json = JSON.toJSONString(result.getBody().getData());
        applicaion = JSON.parseObject(json, Applicaion.class);
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testUpdate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.error(applicaion.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(applicaion), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/applications", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testDetail() {
        Map<String, String> multiValueMap = Maps.newHashMap();
        multiValueMap.put("id", applicaion.getId());
        R r = testRestTemplate.getForObject("/api/admin/applications/{id}", R.class, multiValueMap);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/applications/list", HttpMethod.POST, httpEntity, R.class);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/applications/page", HttpMethod.POST, httpEntity, R.class);
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
        List<String> deleted = Lists.newArrayList(applicaion.getId());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(deleted), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/applications", HttpMethod.DELETE, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

}

