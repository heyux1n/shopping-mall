package com.heyux1n.shopping.mall.common.service.config;

import com.heyux1n.shopping.mall.common.service.interceptor.UserLoginAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: heyux1n
 * @date: 2023/12/3 20:32
 * @description:
 * @version: 1.0.0
 */
public class UserWebMvcConfiguration implements WebMvcConfigurer {


    @Autowired
    private UserLoginAuthInterceptor userLoginAuthInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginAuthInterceptor).addPathPatterns("/api/**/auth/**");
    }
}
