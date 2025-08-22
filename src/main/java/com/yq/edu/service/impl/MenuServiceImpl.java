package com.yq.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.edu.entity.Menu;
import com.yq.edu.entity.Role;
import com.yq.edu.mapper.MenuMapper;
import com.yq.edu.service.MenuService;
import com.yq.edu.util.MenuGenerator;
import com.yq.edu.vo.MenuRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: edu
 * @description: 菜单类业务层实现
 * @author: YeahQing
 * @create: 2019-11-02 22:36
 **/

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public IPage<MenuRoleVo> selectMenuRole(Page<MenuRoleVo> page) {
        return menuMapper.selectMenuRole ( page );
    }

    @Override
    public List<Menu> getMenuListByRoleId(Integer role) {
        //通过菜单生成器构建菜单
        return MenuGenerator.menuGenerator ( menuMapper.getMenuListByRoleId ( role ) );
    }
}
