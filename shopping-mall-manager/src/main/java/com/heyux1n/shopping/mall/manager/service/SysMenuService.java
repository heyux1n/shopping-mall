package com.heyux1n.shopping.mall.manager.service;

import com.heyux1n.shopping.mall.model.entity.system.SysMenu;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/9 20:15
 * @description:
 * @version: 1.0.0
 */
public interface SysMenuService {
    List<SysMenu> findNodes();

    boolean save(SysMenu sysMenu);

    boolean updateById(SysMenu sysMenu);

    boolean removeById(Long id);
}
