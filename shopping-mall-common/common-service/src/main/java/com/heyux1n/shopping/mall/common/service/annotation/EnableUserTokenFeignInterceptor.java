package com.heyux1n.shopping.mall.common.service.annotation;

import com.heyux1n.shopping.mall.common.service.feign.UserTokenFeignInterceptor;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: heyux1n
 * @date: 2023/12/9 20:35
 * @description:
 * @version: 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({UserTokenFeignInterceptor.class})
public @interface EnableUserTokenFeignInterceptor {
}
