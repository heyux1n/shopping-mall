package com.heyux1n.shopping.mall.service.user;

import com.heyux1n.shopping.mall.service.user.properties.SmsProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:08
 * @description: 用户服务启动类
 * @version: 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.heyux1n.shopping"})
@EnableConfigurationProperties(value = {SmsProperties.class})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
