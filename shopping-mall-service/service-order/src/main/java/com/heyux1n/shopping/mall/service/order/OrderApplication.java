package com.heyux1n.shopping.mall.service.order;

import com.heyux1n.shopping.mall.common.service.annotation.EnableUserTokenFeignInterceptor;
import com.heyux1n.shopping.mall.common.service.annotation.EnableUserWebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:19
 * @description:
 * @version: 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.heyux1n.shopping.mall"})
@EnableFeignClients(basePackages = {"com.heyux1n.shopping.mall.client"})
@EnableUserWebMvcConfiguration
@EnableUserTokenFeignInterceptor
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
