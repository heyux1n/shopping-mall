package com.heyux1n.shopping.mall.service.cart;

import com.heyux1n.shopping.mall.common.service.annotation.EnableUserWebMvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: heyux1n
 * @date: 2023/12/9 17:53
 * @description:
 * @version: 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.heyux1n.shopping.mall"})
@EnableFeignClients(basePackages = {"com.heyux1n.shopping.mall.client.product.feign"})
@EnableUserWebMvcConfiguration
public class CartApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartApplication.class, args);
    }
}
