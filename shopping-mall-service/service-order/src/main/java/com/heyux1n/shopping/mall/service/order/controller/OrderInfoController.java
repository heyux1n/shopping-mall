package com.heyux1n.shopping.mall.service.order.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.model.dto.h5.order.OrderInfoDto;
import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.vo.h5.order.TradeVo;
import com.heyux1n.shopping.mall.service.order.service.OrderInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:58
 * @description:
 * @version: 1.0.0
 */
@Tag(name = "订单管理")
@RestController
@RequestMapping(value = "/api/order/orderInfo")
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @Operation(summary = "确认下单")
    @GetMapping("auth/trade")
    public Result<TradeVo> trade() {
        TradeVo tradeVo = orderInfoService.getTrade();
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }


    @Operation(summary = "提交订单")
    @PostMapping("auth/submitOrder")
    public Result<Long> submitOrder(@Parameter(name = "orderInfoDto", description = "请求参数实体类", required = true) @RequestBody OrderInfoDto orderInfoDto) {
        Long orderId = orderInfoService.submitOrder(orderInfoDto);
        return Result.build(orderId, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "获取订单信息")
    @GetMapping("auth/{orderId}")
    public Result<OrderInfo> getOrderInfo(@Parameter(name = "orderId", description = "订单id", required = true) @PathVariable Long orderId) {
        OrderInfo orderInfo = orderInfoService.getOrderInfo(orderId);
        return Result.build(orderInfo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "立即购买")
    @GetMapping("auth/buy/{skuId}")
    public Result<TradeVo> buy(@Parameter(name = "skuId", description = "商品skuId", required = true) @PathVariable Long skuId) {
        TradeVo tradeVo = orderInfoService.buy(skuId);
        return Result.build(tradeVo, ResultCodeEnum.SUCCESS);
    }

    @Operation(summary = "获取订单分页列表")
    @GetMapping("auth/{page}/{limit}")
    public Result<PageInfo<OrderInfo>> list(
            @Parameter(name = "page", description = "当前页码", required = true)
            @PathVariable Integer page,
            @Parameter(name = "limit", description = "每页记录数", required = true)
            @PathVariable Integer limit,
            @Parameter(name = "orderStatus", description = "订单状态")
            @RequestParam(required = false, defaultValue = "") Integer orderStatus) {
        PageInfo<OrderInfo> pageInfo = orderInfoService.findUserPage(page, limit, orderStatus);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }


    @Operation(summary = "获取订单信息")
    @GetMapping("auth/getOrderInfoByOrderNo/{orderNo}")
    public Result<OrderInfo> getOrderInfoByOrderNo(@Parameter(name = "orderId", description = "订单id", required = true) @PathVariable String orderNo) {
        OrderInfo orderInfo = orderInfoService.getByOrderNo(orderNo);
        return Result.build(orderInfo, ResultCodeEnum.SUCCESS);
    }


    @Operation(summary = "更新订单状态")
    @GetMapping("auth/updateOrderStatusPayed/{orderNo}/{payType}")
    public Result updateOrderStatus(@PathVariable(value = "orderNo") String orderNo, @PathVariable(value = "payType") Integer payType) {
        orderInfoService.updateOrderStatus(orderNo, payType);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
