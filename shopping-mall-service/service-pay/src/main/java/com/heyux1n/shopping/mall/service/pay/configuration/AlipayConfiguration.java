package com.heyux1n.shopping.mall.service.pay.configuration;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.heyux1n.shopping.mall.service.pay.properties.AlipayProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:26
 * @description:
 * @version: 1.0.0
 */
@Configuration
public class AlipayConfiguration {

    @Autowired
    private AlipayProperties alipayProperties;

    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(alipayProperties.getAlipayUrl(),
                alipayProperties.getAppId(),
                alipayProperties.getAppPrivateKey(),
                AlipayProperties.format,
                AlipayProperties.charset,
                alipayProperties.getAlipayPublicKey(),
                AlipayProperties.sign_type);
    }

}
