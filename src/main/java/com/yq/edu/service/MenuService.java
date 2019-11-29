package com.yq.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.edu.entity.Menu;
import com.yq.edu.vo.MenuRoleVo;

import java.util.List;

public interface MenuService extends IService<Menu> {
    IPage<MenuRoleVo> selectMenuRole(Page<MenuRoleVo> page);

    //根据角色id获得菜单列表
    List<Menu> getMenuListByRoleId(Integer role);

}
