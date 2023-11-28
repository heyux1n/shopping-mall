package com.heyux1n.shopping.mall.common.log.annotation;

import com.heyux1n.shopping.mall.common.log.aspect.LogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: heyux1n
 * @date: 2023/11/28 21:43
 * @description:
 * @version: 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LogAspect.class)
public @interface EnableLogAspect {
}
