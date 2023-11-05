package com.heyux1n.shopping.mall.model.vo.common;

import lombok.Data;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/5 16:12
 * @description:
 * @version: 1.0.0
 */
@Data
public class ListCheckResult<T> {
    private List<T> allList;

    private List<Long> checkIdList;
}
