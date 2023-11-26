package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.service.ProductSpecService;
import com.heyux1n.shopping.mall.model.entity.product.ProductSpec;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: heyux1n
 * @date: 2023/11/26 16:37
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value="/admin/product/productSpec")
public class ProductSpecController {

    @Autowired
    private ProductSpecService productSpecService ;

    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<ProductSpec>> findByPage(@PathVariable Integer page, @PathVariable Integer limit) {
        PageInfo<ProductSpec> pageInfo = productSpecService.findByPage(page, limit);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }


    @PostMapping("save")
    public Result save(@RequestBody ProductSpec productSpec) {
        return Result.build(productSpecService.save(productSpec) , ResultCodeEnum.SUCCESS) ;
    }

    @PutMapping("updateById")
    public Result updateById(@RequestBody ProductSpec productSpec) {
        return Result.build(productSpecService.updateById(productSpec) , ResultCodeEnum.SUCCESS) ;
    }


    @DeleteMapping("/deleteById/{id}")
    public Result removeById(@PathVariable Long id) {
        return Result.build(productSpecService.deleteById(id) , ResultCodeEnum.SUCCESS) ;
    }
}