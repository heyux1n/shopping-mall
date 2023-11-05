package com.heyux1n.shopping.mall.model.dto.system;

import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/5 16:21
 * @description:
 * @version: 1.0.0
 */
@Data
public class AssignRoleDto {

    private Long userId;				// 用户的id
    private List<Long> roleIdList;		// 角色id

}