package com.heyux1n.shopping.mall.manager.controller;

import com.github.pagehelper.PageInfo;
import com.heyux1n.shopping.mall.manager.service.ProductService;
import com.heyux1n.shopping.mall.model.dto.product.ProductDto;
import com.heyux1n.shopping.mall.model.entity.product.Product;
import com.heyux1n.shopping.mall.model.entity.product.ProductSku;
import com.heyux1n.shopping.mall.model.vo.common.Result;
import com.heyux1n.shopping.mall.model.vo.common.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:29
 * @description:
 * @version: 1.0.0
 */
@RestController
@RequestMapping(value = "/admin/product/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{page}/{limit}")
    public Result<PageInfo<Product>> findByPage(@PathVariable Integer page, @PathVariable Integer limit, ProductDto productDto) {
        PageInfo<Product> pageInfo = productService.findByPage(page, limit, productDto);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Product product) {
        return Result.build(productService.save(product), ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/getById/{id}")
    public Result<Product> getById(@PathVariable Long id) {
        Product product = productService.getById(id);
        return Result.build(product, ResultCodeEnum.SUCCESS);
    }

    @PutMapping("/updateById")
    public Result updateById(@Parameter(name = "product", description = "请求参数实体类", required = true) @RequestBody Product product) {
        return Result.build(productService.updateById(product), ResultCodeEnum.SUCCESS);
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@Parameter(name = "id", description = "商品id", required = true) @PathVariable Long id) {
        return Result.build(productService.deleteById(id), ResultCodeEnum.SUCCESS);
    }

    /**
     * 商品审核
     * @param id
     * @param auditStatus
     * @return
     */
    @GetMapping("/updateAuditStatus/{id}/{auditStatus}")
    public Result updateAuditStatus(@PathVariable Long id, @PathVariable Integer auditStatus) {
        return Result.build(productService.updateAuditStatus(id, auditStatus), ResultCodeEnum.SUCCESS);
    }

    /**
     * 商品上下架
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        return Result.build(productService.updateStatus(id, status), ResultCodeEnum.SUCCESS);
    }

}
