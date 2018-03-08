package com.its.smart.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.its.smart.SmartApplication;
import com.its.smart.api.consts.SmartConsts;
import com.its.smart.api.dto.PageSearch;
import com.its.smart.api.dto.R;
import com.its.smart.api.entity.sys.RoleFunctionRel;
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

import java.util.List;
import java.util.Map;

/**
 * @author mq
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class RoleFunctionRelControllerTest extends AbstractTestNGSpringContextTests implements BaseControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private RoleFunctionRel roleFunctionRel;

    @BeforeTest
    @Override
    public void initData() {
        roleFunctionRel = new RoleFunctionRel();
        roleFunctionRel.setFunctionId("142c4c59c8314be6942976fba6ec7cfc");
        roleFunctionRel.setRoleId("00759bf8e86c4ec3b7b97c0ddde09850");
        roleFunctionRel.setPermissions("12");
        roleFunctionRel.setIsTest(SmartConsts.DataTestType.TEST);

    }

    @Test
    @Override
    public void testCreate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(roleFunctionRel), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/rolefunctionrels", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        String json = JSON.toJSONString(result.getBody().getData());
        roleFunctionRel = JSON.parseObject(json, RoleFunctionRel.class);
    }

    @Test(dependsOnMethods = {"testCreate"})
    public void testUpdate() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        log.error(roleFunctionRel.toString());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(roleFunctionRel), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/rolefunctionrels", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

    @Test(dependsOnMethods = {"testUpdate"})
    @Override
    public void testDetail() {
        Map<String, String> multiValueMap = Maps.newHashMap();
        multiValueMap.put("id", roleFunctionRel.getId());
        R r = testRestTemplate.getForObject("/api/admin/rolefunctionrels/{id}", R.class, multiValueMap);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/rolefunctionrels/list", HttpMethod.POST, httpEntity, R.class);
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
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/rolefunctionrels/page", HttpMethod.POST, httpEntity, R.class);
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
        List<String> deleted = Lists.newArrayList(roleFunctionRel.getId());
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(deleted), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/rolefunctionrels", HttpMethod.DELETE, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
        log.debug("update:{}", result.getBody().getData());
    }

}

