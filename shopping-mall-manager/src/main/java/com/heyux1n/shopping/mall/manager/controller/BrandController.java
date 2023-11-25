package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.service.BrandService;
import com.heyux1n.shopping.mall.model.entity.product.Brand;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 15:22
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value="/admin/product/brand")
public class BrandController {

    @Autowired
    private BrandService brandService ;

    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<Brand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit) {
        PageInfo<Brand> pageInfo = brandService.findByPage(page, limit);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("save")
    public Result save(@RequestBody Brand brand) {
        return Result.build(brandService.save(brand) , ResultCodeEnum.SUCCESS) ;
    }


    @PutMapping("updateById")
    public Result updateById(@RequestBody Brand brand) {
        return Result.build(brandService.updateById(brand) , ResultCodeEnum.SUCCESS) ;
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        return Result.build(brandService.deleteById(id) , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping("/findAll")
    public Result findAll() {
        List<Brand> list = brandService.findAll();
        return Result.build(list , ResultCodeEnum.SUCCESS) ;
    }
}
