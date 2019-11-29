package com.yq.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.Transient;
import java.util.List;

/**
 * @program: edu
 * @description: 菜单实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:48
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_menu")
public class Menu {

    // 菜单id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    // 菜单名称
    @TableField(value = "name")
    private String name;

    // 父菜单id
    @TableField(value = "parent_id")
    private Integer parentId;

    // 菜单url
    @TableField(value = "url")
    private String url;

    // 菜单图标
    @TableField(value = "icon")
    private String icon;

    // 菜单顺序
    @TableField(value = "menu_order")
    private Integer menuOrder;

    //菜单所属角色
    @TableField(value = "role_id")
    private Integer roleId;

    // 子菜单 数据库中不存在的字段
    @TableField(exist = false)
    private List<Menu> childMenus;
}
