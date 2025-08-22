package com.yq.edu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yq.edu.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: edu
 * @description: 角色菜单VO类
 * @author: YeahQing
 * @create: 2019-11-02 22:43
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MenuRoleVo implements Serializable {

    //菜单Id
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    //角色Id
    @TableField("role_id")
    private Integer roleId;

    //角色名称
    @TableField("role_name")
    private String roleName;

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
    private int order;
}
