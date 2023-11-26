package com.heyux1n.shopping.mall.model.entity.product;

import com.heyux1n.shopping.mall.model.entity.base.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/26 17:34
 * @description:
 * @version: 1.0.0
 */
@Data
public class Product extends BaseEntity {

    @Schema(description = "商品名称")
    private String name;
    @Schema(description = "品牌ID")
    private Long brandId;
    @Schema(description = "一级分类id")
    private Long category1Id;
    @Schema(description = "二级分类id")
    private Long category2Id;
    @Schema(description = "三级分类id")
    private Long category3Id;
    @Schema(description = "计量单位")
    private String unitName;
    @Schema(description = "轮播图")
    private String sliderUrls;
    @Schema(description = "商品规格值json串")
    private String specValue;
    @Schema(description = "线上状态：0-初始值，1-上架，-1-自主下架")
    private Integer status;
    @Schema(description = "审核状态")
    private Integer auditStatus;
    @Schema(description = "审核信息")
    private String auditMessage;

    @Schema(description = "品牌")
    private String brandName;
    @Schema(description = "一级分类")
    private String category1Name;
    @Schema(description = "二级分类")
    private String category2Name;
    @Schema(description = "三级分类")
    private String category3Name;


    @Schema(description = "sku列表集合")
    private List<ProductSku> productSkuList;
    @Schema(description = "图片详情列表")
    private String detailsImageUrls;
}