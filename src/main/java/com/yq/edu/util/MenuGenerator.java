package com.yq.edu.util;

import com.yq.edu.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: edu
 * @description: 菜单生成器
 * @author: YeahQing
 * @create: 2019-11-03 09:33
 **/

public class MenuGenerator {

    public static List<Menu> menuGenerator(List<Menu> menus){
        //最终返回的menuList
        List<Menu> menuList = new ArrayList<Menu> ();
        //构建目录
        menus.forEach ( m -> {
            if(m.getParentId () == 0){
                //如果m的ParentId为0则为目录，将其先添加到返回的集合中
                menuList.add (m);
            }
        } );

        menuList.forEach ( rootMenu -> {
            rootMenu.setChildMenus ( getChildMenuList(rootMenu.getId (),menus) );
        } );

        return menuList;
    }

    //获取子目录
    private static List<Menu> getChildMenuList(Integer menuId, List<Menu> menus){
        //构建子菜单
        ArrayList<Menu> childList = new ArrayList<> ();
        //遍历menus
        menus.forEach ( m -> {
            if(m.getParentId () != 0){
                if(m.getParentId ().equals ( menuId )){
                    childList.add ( m );
                }
            }
        } );

        if(childList.size () == 0){
            return null;
        }

        return childList;
    }

}
