package com.heyux1n.shopping.mall.service.pay.service;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:27
 * @description:
 * @version: 1.0.0
 */
public interface AlipayService {
    /**
     * 提价支付
     * @param orderNo
     * @return
     */
    String submitAlipay(String orderNo);
}
