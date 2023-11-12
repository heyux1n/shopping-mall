package com.heyux1n.shopping.mall.manager.mapper;

import com.heyux1n.shopping.mall.model.entity.system.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: heyux1n
 * @date: 2023/11/9 20:17
 * @description:
 * @version: 1.0.0
 */
@Mapper
public interface SysMenuMapper {
    public abstract  List<SysMenu> findAll();

    public abstract boolean save(SysMenu sysMenu);

    public abstract  boolean updateById(SysMenu sysMenu);


    public abstract boolean deleteById(Long id);

    List<SysMenu> selectListByUserId(Long userId);
}
