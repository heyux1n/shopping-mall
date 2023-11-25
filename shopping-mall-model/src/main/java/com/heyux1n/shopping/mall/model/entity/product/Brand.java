package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: heyux1n
 * @date: 2023/11/25 15:22
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "品牌")
@Data
public class Brand extends BaseEntity {

    @Schema(description = "名称")
    private String name;
    @Schema(description = "logo")
    private String logo;

}