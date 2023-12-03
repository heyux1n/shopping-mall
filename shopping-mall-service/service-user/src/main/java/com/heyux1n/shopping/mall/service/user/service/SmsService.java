package com.heyux1n.shopping.mall.service.user.service;

/**
 * @author: heyux1n
 * @date: 2023/12/3 17:25
 * @description:
 * @version: 1.0.0
 */
public interface SmsService {
    /**
     * 发送验证码
     * @param phone
     */
    void sendCaptcha(String phone);
}
