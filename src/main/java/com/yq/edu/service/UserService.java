package com.yq.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.edu.entity.User;
import com.yq.edu.vo.UserRoleVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService extends IService<User> {

    User loginByUserIdAndPassWord(String userId, String passWord);

    UserRoleVo getUserAndRole(Integer roleId,String userId);

    void delUser(String userId);

    void saveUser(List<User> userList);

    void updatePassWord(User user);
}
