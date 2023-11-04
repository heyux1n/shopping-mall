package com.heyux1n.shopping.mall.manager.config;

import com.heyux1n.shopping.mall.manager.interceptor.LoginAuthInterceptor;
import com.heyux1n.shopping.mall.manager.properties.UserAuthProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: heyux1n
 * @date: 2023/10/30 21:06
 * @description:
 * @version: 1.0.0
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private UserAuthProperties userAuthProperties;
    @Autowired
    private LoginAuthInterceptor loginAuthInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginAuthInterceptor)
                .excludePathPatterns(userAuthProperties.getNoAuthUrls())
                .addPathPatterns("/**");
    }
}
