package com.heyux1n.shopping.mall.service.pay.service;

import com.heyux1n.shopping.mall.model.entity.h5.pay.PaymentInfo;

import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:36
 * @description:
 * @version: 1.0.0
 */
public interface PaymentInfoService {
    /**
     * 保存支付信息
     * @param orderNo
     * @return
     */
    PaymentInfo savePaymentInfo(String orderNo);

    /**
     * 更新支付状态
     * @param paramMap
     * @param payType
     */
    void updatePaymentStatus(Map<String, String> paramMap, Integer payType);


}
