package com.heyux1n.shopping.mall.manager.controller;

import com.heyux1n.shopping.mall.manager.service.ProductUnitService;
import com.heyux1n.shopping.mall.model.entity.product.ProductUnit;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:33
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping("/admin/product/productUnit")
public class ProductUnitController {

    @Autowired
    private ProductUnitService productUnitService;

    @GetMapping("findAll")
    public Result<List<ProductUnit>> findAll() {
        List<ProductUnit> productUnitList = productUnitService.findAll();
        return Result.build(productUnitList , ResultCodeEnum.SUCCESS) ;
    }
}
