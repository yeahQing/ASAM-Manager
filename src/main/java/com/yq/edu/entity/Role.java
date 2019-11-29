package com.yq.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: edu
 * @description: 角色实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:48
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_role")
public class Role {

    @TableId(value = "role_id",type = IdType.AUTO)
    private Integer roleId;

    @TableField(value = "role_name")
    private String roleName;

}
