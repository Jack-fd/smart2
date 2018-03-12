package com.its.smart.web.controller.sys;

import com.alibaba.fastjson.JSON;
import com.its.smart.SmartApplication;
import com.its.smart.api.dto.R;
import com.its.smart.api.dto.SignIn;
import com.its.smart.api.entity.sys.Applicaion;
import com.its.smart.api.entity.sys.User;
import com.its.smart.web.shiro.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author mq
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmartApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@Slf4j
public class AccountControllerTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void signIn() {
        SignIn signIn = new SignIn();
        signIn.setName("admin<href></href>");
        signIn.setPassword("admin");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<>(JSON.toJSONString(signIn), headers);
        ResponseEntity<R> result = testRestTemplate.exchange("/api/admin/accounts/sign-in", HttpMethod.POST, httpEntity, R.class);
        log.error(result.getBody().toString());
        Assert.assertEquals(result.getStatusCode().value(), 200);
        Assert.assertEquals(result.getBody().getErrorCode(), 0);
    }

    @Test
    public void signOut() {

    }

    @Test
    public void userInfo() {

    }
}
