package com.heyux1n.shopping.mall.service.pay.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:21
 * @description:
 * @version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "shopping-mall.alipay")
public class AlipayProperties {

    private String alipayUrl;
    private String appPrivateKey;
    public  String alipayPublicKey;
    private String appId;
    public  String returnPaymentUrl;
    public  String notifyPaymentUrl;

    public final static String format="json";
    public final static String charset="utf-8";
    public final static String sign_type="RSA2";

}
