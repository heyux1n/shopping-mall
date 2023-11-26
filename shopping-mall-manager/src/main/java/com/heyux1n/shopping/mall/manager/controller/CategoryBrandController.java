package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.service.CategoryBrandService;
import com.heyux1n.shopping.mall.model.dto.product.CategoryBrandDto;
import com.heyux1n.shopping.mall.model.entity.product.Brand;
import com.heyux1n.shopping.mall.model.entity.product.CategoryBrand;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/25 16:53
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/product/categoryBrand")
public class CategoryBrandController {

    @Autowired
    private CategoryBrandService categoryBrandService ;

    @GetMapping("/{page}/{limit}")
    public Result<PageInfo<CategoryBrand>> findByPage(@PathVariable Integer page, @PathVariable Integer limit, CategoryBrandDto CategoryBrandDto) {
        PageInfo<CategoryBrand> pageInfo = categoryBrandService.findByPage(page, limit, CategoryBrandDto);
        return Result.build(pageInfo , ResultCodeEnum.SUCCESS) ;
    }

    @PostMapping("/save")
    public Result save(@RequestBody CategoryBrand categoryBrand) {
        return Result.build(categoryBrandService.save(categoryBrand) , ResultCodeEnum.SUCCESS) ;
    }

    @PutMapping("updateById")
    public Result updateById(@RequestBody CategoryBrand categoryBrand) {
        return Result.build(categoryBrandService.updateById(categoryBrand) , ResultCodeEnum.SUCCESS) ;
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        return Result.build(categoryBrandService.deleteById(id) , ResultCodeEnum.SUCCESS) ;
    }

    @GetMapping("/findBrandByCategoryId/{categoryId}")
    public Result findBrandByCategoryId(@PathVariable Long categoryId) {
        List<Brand> brandList =   categoryBrandService.findBrandByCategoryId(categoryId);
        return Result.build(brandList , ResultCodeEnum.SUCCESS) ;
    }

}