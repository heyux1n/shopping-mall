package com.heyux1n.shopping.mall.manager.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/10/30 21:40
 * @description:
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "shopping-mall.auth")      // 前缀不能使用驼峰命名
public class UserAuthProperties {
    private List<String> noAuthUrls ;
}
