package com.heyux1n.shopping.mall.model.entity.h5.pay;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: heyux1n
 * @date: 2023/12/10 20:15
 * @description:
 * @version: 1.0.0
 */
@Data
@Schema(description = "支付信息实体类")
public class PaymentInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户id")
    private Long userId;

    @Schema(description = "订单号")
    private String orderNo;

    @Schema(description = "付款方式：1-微信 2-支付宝")
    private Integer payType;

    @Schema(description = "交易编号（微信或支付）")
    private String outTradeNo;

    @Schema(description = "支付金额")
    private BigDecimal amount;

    @Schema(description = "交易内容")
    private String content;

    @Schema(description = "支付状态：0-未支付 1-已支付")
    private Integer paymentStatus;

    @Schema(description = "回调时间")
    private Date callbackTime;

    @Schema(description = "回调信息")
    private String callbackContent;

}