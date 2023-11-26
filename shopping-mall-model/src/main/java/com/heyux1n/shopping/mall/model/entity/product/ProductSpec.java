package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/26 16:38
 * @description:
 * @version: 1.0.0
 */
@Data
public class ProductSpec extends BaseEntity {

    @Schema(description = "规格名称")
    private String specName;
    @Schema(description = "规格值")
    private String specValue;

}