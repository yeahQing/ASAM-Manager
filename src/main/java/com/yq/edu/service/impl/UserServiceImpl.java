package com.yq.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.edu.entity.User;
import com.yq.edu.mapper.UserMapper;
import com.yq.edu.service.UserService;
import com.yq.edu.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: edu
 * @description: 用户业务层
 * @author: YeahQing
 * @create: 2019-11-02 20:54
 **/

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User loginByUserIdAndPassWord(String userId, String passWord) {
        return userMapper.selectOne ( new QueryWrapper<User>().eq ( "user_id",userId ).and (i -> i.eq ( "user_pwd",passWord )));
    }

    @Override
    public UserRoleVo getUserAndRole(Integer roleId,String userId) {
        return userMapper.getUserAndRole ( roleId, userId );
    }

    @Override
    public void delUser(String userId){
        userMapper.deleteById ( userId );
    }

    @Override
    public void saveUser(List<User> userList) {
        int count = 0;
        for(User u : userList){
            System.out.println (u.getUserId ()+":"+u.getUserName ()+":"+u.getPassWord ()+":"+u.getRoleId ());
            int save = userMapper.insert ( u );
            if(save > 0){
                System.out.println ("储存到数据库成功!");
                count++;
            }
        }

        if(count == userList.size ()){
            System.out.println ("全部储存成功!");
        }
    }

    @Override
    public void updatePassWord(User user) {
        userMapper.updateById ( user );
    }
}
