package com.heyux1n.shopping.mall.manager.helper;

import cn.hutool.core.collection.CollectionUtil;
import com.heyux1n.shopping.mall.model.entity.system.SysMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: heyux1n
 * @date: 2023/11/9 20:23
 * @description:
 * @version: 1.0.0
 */
public class MenuHelper {

    public static List<SysMenu> buildTree(List<SysMenu> sysMenuList) {
        Map<Long, List<SysMenu>> sysMenuMap = new HashMap<>(16);
        for (SysMenu sysMenu : sysMenuList) {
            Long key = sysMenu.getParentId();
            List<SysMenu> value = sysMenuMap.get(key);
            if(value == null) {
                value = new ArrayList<>();
            }
            value.add(sysMenu);
            sysMenuMap.put(key, value);
        }

        List<SysMenu> sysMenuTree = new ArrayList<>();
        for (SysMenu sysMenu : sysMenuList) {
            Long parentId = sysMenu.getParentId();
            if(parentId != 0) {
                continue;
            }
            List<SysMenu> menuChildList = getMenuChild(sysMenu, sysMenuMap);
            sysMenu.setChildren(menuChildList);
            sysMenuTree.add(sysMenu);
        }
        return sysMenuTree;
    }


    private static List<SysMenu> getMenuChild(SysMenu sysMenu, Map<Long, List<SysMenu>> sysMenuMap) {
        List<SysMenu> childMenuList = sysMenuMap.get(sysMenu.getId());
        if(CollectionUtil.isEmpty(childMenuList)) {
            return null;
        }
        for (SysMenu menu : childMenuList) {
            List<SysMenu> menuChild = getMenuChild(menu, sysMenuMap);
            menu.setChildren(menuChild);
        }
        return childMenuList;
    }
}
