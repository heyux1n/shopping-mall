package com.heyux1n.shopping.mall.service.pay.mapper;

import com.heyux1n.shopping.mall.model.entity.h5.pay.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: heyux1n
 * @date: 2023/12/10 21:00
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface PaymentInfoMapper {
    /**
     * 新增支付信息
     * @param paymentInfo
     */
    void save(PaymentInfo paymentInfo);

    /**
     * 根据编号获取支付信息
     * @param orderNo
     * @return
     */
    PaymentInfo getByOrderNo(String orderNo);

    /**
     * 更新祝福信息
     * @param paymentInfo
     */
    void updateById(PaymentInfo paymentInfo);
}
