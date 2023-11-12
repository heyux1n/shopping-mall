package com.heyux1n.shopping.mall.model.dto.system;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/9 21:51
 * @description: 分配菜单参数
 * @version: 1.0.0
 */
@Schema(description = "分配菜单参数")
@Data
public class AssignMenuDto {
    @Schema(description = "角色id")
    private Long roleId;
    @Schema(description = "分配的菜单")
    private List<Long> menuIdList;
}