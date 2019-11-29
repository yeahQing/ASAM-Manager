package com.yq.edu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yq.edu.entity.Menu;
import com.yq.edu.service.MenuService;
import com.yq.edu.service.RoleService;
import com.yq.edu.vo.MenuRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: edu
 * @description: 菜单控制器
 * @author: YeahQing
 * @create: 2019-11-02 23:01
 **/

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    //根据roleId获取菜单
    @GetMapping("/{roleId}")
    public String getMenuByRole(@PathVariable Integer roleId, Model model){
        List<Menu> menuList = menuService.getMenuListByRoleId ( roleId );
        //将menuList添加到request域中
        model.addAttribute ( "menuList",menuList );
        //给request域中添加默认标题
        model.addAttribute ( "path_title", "首页" );
        switch (roleId){
            case 1: model.addAttribute ( "content","/admin/dashboard" );break;
            case 2: model.addAttribute ( "content","/student/dashboard" );break;
            case 3: model.addAttribute ( "content","/teacher/dashboard" );break;
        }
        return "main";
    }

    //通过查询菜单 Restful接口
    @GetMapping("getAllMenu/{roleId}")
    @ResponseBody
    public Map<String,Object> getAllMenu(@PathVariable Integer roleId){
        Map<String,Object> map = new HashMap<>();
        List<Menu> menuList = menuService.getMenuListByRoleId ( roleId );
        if(menuList.size () == 0){
            map.put ("code",400);
        }else{
            map.put ("code",200);
            map.put ("data",menuList);
        }
        return map;
    }

    //分页查询菜单
    @GetMapping("/selectAllMenuWithRoleByPage/{page}/{size}")
    @ResponseBody
    public Map<String, Object> selectAllMenuWithRoleByPage(@PathVariable Integer page, @PathVariable Integer size) {
        Map<String, Object> map = new HashMap<>();
        IPage<MenuRoleVo> menuRoleVoIPage = menuService.selectMenuRole ( new Page<> ( page, size ) );
        if (menuRoleVoIPage.getRecords().size() == 0) {
            map.put("code", 400);
        } else {
            map.put("code", 200);
            map.put("data", menuRoleVoIPage);
        }
        return map;
    }

}
