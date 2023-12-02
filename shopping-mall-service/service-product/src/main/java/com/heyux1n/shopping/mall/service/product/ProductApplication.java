package com.heyux1n.shopping.mall.service.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: heyux1n
 * @date: 2023/12/2 15:31
 * @description:
 * @version: 1.0.0
 */
@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.heyux1n.shopping"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
