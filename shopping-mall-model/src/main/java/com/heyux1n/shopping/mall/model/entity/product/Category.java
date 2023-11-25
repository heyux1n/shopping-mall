package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/19 11:17
 * @description:
 * @version: 1.0.0
 */
@Data
public class Category extends BaseEntity {

    private String name;
    private String imageUrl;
    private Long parentId;
    private Integer status;
    private Integer orderNum;

    private Boolean hasChildren;

    private List<Category> children;

}