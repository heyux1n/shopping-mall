package com.heyux1n.shopping.mall.manager;

import com.heyux1n.shopping.mall.common.log.annotation.EnableLogAspect;
import com.heyux1n.shopping.mall.manager.properties.MinioProperties;
import com.heyux1n.shopping.mall.manager.properties.UserAuthProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigurationProperties(value = {UserAuthProperties.class, MinioProperties.class})
@ComponentScan(basePackages = {"com.heyux1n.shopping"})
@EnableLogAspect
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }
}
