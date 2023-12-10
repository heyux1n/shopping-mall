package com.heyux1n.shopping.mall.service.pay;

import com.heyux1n.shopping.mall.common.service.annotation.EnableUserWebMvcConfiguration;
import com.heyux1n.shopping.mall.service.pay.properties.AlipayProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:10
 * @description:
 * @version: 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.heyux1n.shopping.mall"})
@EnableFeignClients(basePackages = {"com.heyux1n.shopping.mall.client"})
@EnableUserWebMvcConfiguration
@EnableConfigurationProperties({AlipayProperties.class})
public class PayApplication {

    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}
