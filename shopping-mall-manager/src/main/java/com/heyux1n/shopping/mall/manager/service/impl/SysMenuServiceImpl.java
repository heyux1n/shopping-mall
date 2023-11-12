package com.heyux1n.shopping.mall.manager.service.impl;

import com.heyux1n.shopping.mall.common.util.AuthContextUtil;
import com.heyux1n.shopping.mall.manager.helper.MenuHelper;
import com.heyux1n.shopping.mall.manager.mapper.SysMenuMapper;
import com.heyux1n.shopping.mall.manager.service.SysMenuService;
import com.heyux1n.shopping.mall.model.entity.system.SysMenu;
import com.heyux1n.shopping.mall.model.entity.system.SysUser;
import com.heyux1n.shopping.mall.model.vo.system.SysMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    @Override
    public List<SysMenuVo> findUserMenuList() {
        //获取当前登录用户的id
        SysUser sysUser = AuthContextUtil.get();
        Long userId = sysUser.getId();
        List<SysMenu> sysMenuList = sysMenuMapper.selectListByUserId(userId);
        return this.buildMenus(sysMenuList);
    }

    private List<SysMenuVo> buildMenus(List<SysMenu> menus) {

        List<SysMenuVo> sysMenuVoList = new LinkedList<>();
        for (SysMenu sysMenu : menus) {
            SysMenuVo sysMenuVo = new SysMenuVo();
            sysMenuVo.setTitle(sysMenu.getTitle());
            sysMenuVo.setName(sysMenu.getComponent());
            sysMenuVoList.add(sysMenuVo);
        }
        return sysMenuVoList;
    }
}
