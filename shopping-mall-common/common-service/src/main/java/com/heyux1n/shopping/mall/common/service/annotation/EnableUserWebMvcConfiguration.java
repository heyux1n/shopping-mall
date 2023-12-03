package com.heyux1n.shopping.mall.common.service.annotation;

import com.heyux1n.shopping.mall.common.service.config.UserWebMvcConfiguration;
import com.heyux1n.shopping.mall.common.service.interceptor.UserLoginAuthInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: heyux1n
 * @date: 2023/12/3 20:34
 * @description:
 * @version: 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({UserLoginAuthInterceptor.class, UserWebMvcConfiguration.class})
public @interface EnableUserWebMvcConfiguration {
}
