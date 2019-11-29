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
 * @description: 用户实体类
 * @author: YeahQing
 * @create: 2019-11-02 20:48
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tbl_user")
public class User {
    //用户id 登录名
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;
    //用户名
    @TableField(value = "user_name")
    private String userName;
    //密码
    @TableField(value = "user_pwd")
    private String passWord;
    //用户所属角色
    @TableField(value = "role_id")
    private Integer roleId;
}
