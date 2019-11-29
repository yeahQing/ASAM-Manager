package com.yq.edu.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: edu
 * @description: 用户角色VO
 * @author: YeahQing
 * @create: 2019-11-03 09:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleVo implements Serializable {
    //用户id 登录名
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;
    //用户名
    @TableField(value = "user_name")
    private String userName;
    //密码
    @TableField(value = "user_pwd")
    private String userPwd;
    //用户所属角色
    @TableField(value = "role_id")
    private Integer roleId;
    //角色名称
    @TableField("role_name")
    private String roleName;
}
