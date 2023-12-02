package com.heyux1n.shopping.mall.service.product.controller;

import com.heyux1n.shopping.mall.model.entity.product.Category;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import com.heyux1n.shopping.mall.model.vo.h5.IndexVo;
import com.heyux1n.shopping.mall.service.product.service.CategoryService;
import com.heyux1n.shopping.mall.service.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/12/2 15:56
 * @description:
 * @version: 1.0.0
 */
@Tag(name = "首页接口管理")
@RestController
@RequestMapping(value="/api/product/index")
public class IndexController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @Operation(summary = "获取首页数据")
    @GetMapping
    public Result<IndexVo> findData(){
        List<Category> categoryList = categoryService.findOneCategory();
        List<ProductSku> productSkuList = productService.findProductSkuBySale();
        IndexVo indexVo = new IndexVo() ;
        indexVo.setCategoryList(categoryList);
        indexVo.setProductSkuList(productSkuList);
        return Result.build(indexVo , ResultCodeEnum.SUCCESS);
    }

}