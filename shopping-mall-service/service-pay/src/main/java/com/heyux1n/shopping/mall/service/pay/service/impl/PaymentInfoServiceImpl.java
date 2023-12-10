package com.heyux1n.shopping.mall.service.pay.service.impl;

import com.alibaba.fastjson.JSON;
import com.heyux1n.shopping.mall.client.order.feign.OrderFeignClient;
import com.heyux1n.shopping.mall.client.product.feign.ProductFeignClient;
import com.heyux1n.shopping.mall.model.dto.h5.SkuSaleDto;
import com.heyux1n.shopping.mall.model.entity.h5.order.OrderItem;
import com.heyux1n.shopping.mall.model.entity.h5.pay.PaymentInfo;
import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import com.heyux1n.shopping.mall.service.pay.mapper.PaymentInfoMapper;
import com.heyux1n.shopping.mall.service.pay.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:36
 * @description:
 * @version: 1.0.0
 */
@Service
public class PaymentInfoServiceImpl implements PaymentInfoService {
    @Autowired
    private PaymentInfoMapper paymentInfoMapper;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private OrderFeignClient orderFeignClient;

    @Override
    public PaymentInfo savePaymentInfo(String orderNo) {
        // 查询支付信息数据，如果已经已经存在了就不用进行保存(一个订单支付失败以后可以继续支付)
        PaymentInfo paymentInfo = paymentInfoMapper.getByOrderNo(orderNo);
        if (null == paymentInfo) {
            OrderInfo orderInfo = orderFeignClient.getOrderInfoByOrderNo(orderNo).getData();
            paymentInfo = new PaymentInfo();
            paymentInfo.setUserId(orderInfo.getUserId());
            paymentInfo.setPayType(orderInfo.getPayType());
            String content = "";
            for (OrderItem item : orderInfo.getOrderItemList()) {
                content += item.getSkuName() + " ";
            }
            paymentInfo.setContent(content);
            paymentInfo.setAmount(orderInfo.getTotalAmount());
            paymentInfo.setOrderNo(orderNo);
            paymentInfo.setPaymentStatus(0);
            paymentInfoMapper.save(paymentInfo);
        }
        return paymentInfo;
    }

    @Override
    public void updatePaymentStatus(Map<String, String> paramMap, Integer payType) {
        // 查询PaymentInfo
        PaymentInfo paymentInfo = paymentInfoMapper.getByOrderNo(paramMap.get("out_trade_no"));
        if (paymentInfo.getPaymentStatus() == 1) {
            return;
        }
        //更新支付信息
        paymentInfo.setPaymentStatus(1);
        paymentInfo.setOutTradeNo(paramMap.get("trade_no"));
        paymentInfo.setCallbackTime(new Date());
        paymentInfo.setCallbackContent(JSON.toJSONString(paramMap));
        paymentInfoMapper.updateById(paymentInfo);

        //更新订单支付状态
        orderFeignClient.updateOrderStatus(paymentInfo.getOrderNo(), payType);

        //更新销量
        OrderInfo orderInfo = orderFeignClient.getOrderInfoByOrderNo(paymentInfo.getOrderNo()).getData();
        List<SkuSaleDto> skuSaleDtoList = orderInfo.getOrderItemList().stream().map(item -> {
            SkuSaleDto skuSaleDto = new SkuSaleDto();
            skuSaleDto.setSkuId(item.getSkuId());
            skuSaleDto.setNum(item.getSkuNum());
            return skuSaleDto;
        }).collect(Collectors.toList());
        productFeignClient.updateSkuSaleNum(skuSaleDtoList);
    }
}
