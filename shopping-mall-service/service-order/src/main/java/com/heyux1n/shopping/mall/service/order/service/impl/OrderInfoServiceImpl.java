package com.heyux1n.shopping.mall.service.order.service.impl;

import com.heyux1n.shopping.mall.client.cart.feign.CartFeignClient;
import com.heyux1n.shopping.mall.client.product.feign.ProductFeignClient;
import com.heyux1n.shopping.mall.client.user.feign.UserFeignClient;
import com.heyux1n.shopping.mall.common.service.exception.ServiceResException;
import com.heyux1n.shopping.mall.common.service.util.AuthContextUtil;
import com.heyux1n.shopping.mall.model.dto.h5.order.OrderInfoDto;
import com.heyux1n.shopping.mall.model.entity.h5.CartInfo;
import com.heyux1n.shopping.mall.model.entity.h5.UserAddress;
import com.heyux1n.shopping.mall.model.entity.h5.UserInfo;
import com.heyux1n.shopping.mall.model.entity.h5.order.OrderItem;
import com.heyux1n.shopping.mall.model.entity.h5.order.OrderLog;
import com.heyux1n.shopping.mall.model.entity.product.OrderInfo;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.vo.h5.order.TradeVo;
import com.heyux1n.shopping.mall.service.order.mapper.OrderInfoMapper;
import com.heyux1n.shopping.mall.service.order.mapper.OrderItemMapper;
import com.heyux1n.shopping.mall.service.order.mapper.OrderLogMapper;
import com.heyux1n.shopping.mall.service.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/9 19:58
 * @description:
 * @version: 1.0.0
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private CartFeignClient cartFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private ProductFeignClient productFeignClient;
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private OrderLogMapper orderLogMapper;

    @Override
    @Transactional
    public Long submitOrder(OrderInfoDto orderInfoDto) {
        // 数据校验
        List<OrderItem> orderItemList = orderInfoDto.getOrderItemList();
        if (CollectionUtils.isEmpty(orderItemList)) {
            throw new ServiceResException(ResultCodeEnum.DATA_ERROR);
        }

        for (OrderItem orderItem : orderItemList) {
            ProductSku productSku = productFeignClient.getBySkuId(orderItem.getSkuId());
            if (null == productSku) {
                throw new ServiceResException(ResultCodeEnum.DATA_ERROR);
            }
            //校验库存
            if (orderItem.getSkuNum().intValue() > productSku.getStockNum().intValue()) {
                throw new ServiceResException(ResultCodeEnum.STOCK_LESS);
            }
        }

        // 构建订单数据，保存订单
        UserInfo userInfo = AuthContextUtil.getUserInfo();
        OrderInfo orderInfo = new OrderInfo();
        //订单编号
        orderInfo.setOrderNo(String.valueOf(System.currentTimeMillis()));
        //用户id
        orderInfo.setUserId(userInfo.getId());
        //用户昵称
        orderInfo.setNickName(userInfo.getNickName());
        //用户收货地址信息
        UserAddress userAddress = userFeignClient.getUserAddress(orderInfoDto.getUserAddressId());
        orderInfo.setReceiverName(userAddress.getName());
        orderInfo.setReceiverPhone(userAddress.getPhone());
        orderInfo.setReceiverTagName(userAddress.getTagName());
        orderInfo.setReceiverProvince(userAddress.getProvinceCode());
        orderInfo.setReceiverCity(userAddress.getCityCode());
        orderInfo.setReceiverDistrict(userAddress.getDistrictCode());
        orderInfo.setReceiverAddress(userAddress.getFullAddress());
        //订单金额
        BigDecimal totalAmount = new BigDecimal(0);
        for (OrderItem orderItem : orderItemList) {
            totalAmount = totalAmount.add(orderItem.getSkuPrice().multiply(new BigDecimal(orderItem.getSkuNum())));
        }
        orderInfo.setTotalAmount(totalAmount);
        orderInfo.setCouponAmount(new BigDecimal(0));
        orderInfo.setOriginalTotalAmount(totalAmount);
        orderInfo.setFreight(orderInfoDto.getFeightFee());
        orderInfo.setPayType(2);
        orderInfo.setOrderStatus(0);
        orderInfoMapper.save(orderInfo);

        //保存订单明细
        for (OrderItem orderItem : orderItemList) {
            orderItem.setOrderId(orderInfo.getId());
            orderItemMapper.save(orderItem);
        }

        //记录日志
        OrderLog orderLog = new OrderLog();
        orderLog.setOrderId(orderInfo.getId());
        orderLog.setProcessStatus(0);
        orderLog.setNote("提交订单");
        orderLogMapper.save(orderLog);

        cartFeignClient.deleteChecked();
        return orderInfo.getId();
    }

    @Override
    public TradeVo getTrade() {
        // 获取选中的购物项列表数据
        List<CartInfo> cartInfoList = cartFeignClient.getAllChecked();
        List<OrderItem> orderItemList = new ArrayList<>();
        // 将购物项数据转换成功订单明细数据
        for (CartInfo cartInfo : cartInfoList) {
            OrderItem orderItem = new OrderItem();
            orderItem.setSkuId(cartInfo.getSkuId());
            orderItem.setSkuName(cartInfo.getSkuName());
            orderItem.setSkuNum(cartInfo.getSkuNum());
            orderItem.setSkuPrice(cartInfo.getCartPrice());
            orderItem.setThumbImg(cartInfo.getImgUrl());
            orderItemList.add(orderItem);
        }

        // 计算总金额
        BigDecimal totalAmount = new BigDecimal(0);
        for (OrderItem orderItem : orderItemList) {
            totalAmount = totalAmount.add(orderItem.getSkuPrice().multiply(new BigDecimal(orderItem.getSkuNum())));
        }
        TradeVo tradeVo = new TradeVo();
        tradeVo.setTotalAmount(totalAmount);
        tradeVo.setOrderItemList(orderItemList);
        return tradeVo;
    }

    @Override
    public OrderInfo getOrderInfo(Long orderId) {
        return null;
    }
}
