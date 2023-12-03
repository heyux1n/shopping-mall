package com.heyux1n.shopping.mall.common.service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @author: heyux1n
 * @date: 2023/11/4 15:31
 * @description:
 * @version: 1.0.0
 */
@Configuration
public class Knife4jConfig {

    @Bean
    public GroupedOpenApi adminApi() {
        //创建了一个api接口的分组
        return GroupedOpenApi.builder()
                //分组名称
                .group("admin-api")
                //接口请求路径规则
                .pathsToMatch("/admin/**")
                .build();
    }

    @Bean
    public GroupedOpenApi webApi() {
        //创建了一个api接口的分组
        return GroupedOpenApi.builder()
                //分组名称
                .group("web-api")
                //接口请求路径规则
                .pathsToMatch("/api/**")
                .build();
    }

    /***
     * @description 自定义接口信息
     */
    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("尚品甑选API接口文档")
                        .version("1.0")
                        .description("尚品甑选API接口文档")
                        // 设定作者
                        .contact(new Contact().name("heyux1n")));
    }
}
