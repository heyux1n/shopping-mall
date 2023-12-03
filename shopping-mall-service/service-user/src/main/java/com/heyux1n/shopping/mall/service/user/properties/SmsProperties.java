package com.heyux1n.shopping.mall.service.user.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:15
 * @description: 阿里短信配置
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "shopping-mall.sms")
public class SmsProperties {
    private String host;
    private String path;
    private String appcode;
}
