package com.heyux1n.shopping.mall.model.vo.h5;

import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 15:54
 * @description:
 * @version: 1.0.0
 */
@Schema(description = "h5首页数据")
@Data
public class IndexVo {

    @Schema(description = "一级分类的类别数据")
    private List<Category> categoryList;
    @Schema(description = "畅销商品列表数据")
    private List<ProductSku> productSkuList;

}