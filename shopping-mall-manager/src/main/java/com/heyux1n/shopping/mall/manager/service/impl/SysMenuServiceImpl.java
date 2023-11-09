package com.heyux1n.shopping.mall.manager.service.impl;

import com.heyux1n.shopping.mall.manager.helper.MenuHelper;
import com.heyux1n.shopping.mall.manager.mapper.SysMenuMapper;
import com.heyux1n.shopping.mall.manager.service.SysMenuService;
import com.heyux1n.shopping.mall.model.entity.system.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/9 20:17
 * @description:
 * @version: 1.0.0
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> findNodes() {
        List<SysMenu> sysMenuList = sysMenuMapper.findAll();
        //parentId：0一级菜单
        return MenuHelper.buildTree(sysMenuList);
    }


    @Override
    public boolean save(SysMenu sysMenu) {
        return sysMenuMapper.save(sysMenu);
    }

    @Override
    public boolean updateById(SysMenu sysMenu) {

        return sysMenuMapper.updateById(sysMenu);
    }

    @Override
    public boolean removeById(Long id) {
        return sysMenuMapper.deleteById(id);
    }
}
