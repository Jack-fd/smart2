package com.its.smart;

import lombok.extern.java.Log;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Smart管理平台启动入口
 *
 * @author MQ
 */

@EnableTransactionManagement
@SpringBootApplication
@Log
public class SmartApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SmartApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
        log.info("SmartApplication is success!");
        System.err.println("sample started. http://localhost:7890/smart");
    }
}
