package com.heyux1n.shopping.mall.client.order.feign;

import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:14
 * @description:
 * @version: 1.0.0
 */
@FeignClient(value = "service-order")
public interface OrderFeignClient {

    /**
     * 根据订单编号获取订单信息
     *
     * @param orderNo
     * @return
     */
    @GetMapping("/api/order/orderInfo/auth/getOrderInfoByOrderNo/{orderNo}")
    public Result<OrderInfo> getOrderInfoByOrderNo(@PathVariable String orderNo);


    /**
     * 更新订单状态
     *
     * @param orderNo
     * @param payType
     * @return
     */
    @GetMapping("/api/order/orderInfo/auth/updateOrderStatusPayed/{orderNo}/{payType}")
    public Result updateOrderStatus(@PathVariable(value = "orderNo") String orderNo, @PathVariable(value = "payType") Integer payType);
}
