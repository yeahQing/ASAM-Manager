package com.yq.edu;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yq.edu.entity.User;
import com.yq.edu.mapper.UserMapper;
import com.yq.edu.vo.UserRoleVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: edu
 * @description: UserMapper测试类
 * @author: YeahQing
 * @create: 2019-11-02 20:52
 **/

@ExtendWith (SpringExtension.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    UserMapper userMapper;

    //查询全部
    @Test
    public void selectTest(){
        List<User> userList = userMapper.selectList ( null );
        userList.forEach ( System.out::println );
    }

    @Test
    public void selectUserByRoleId(){
        UserRoleVo user = userMapper.getUserAndRole ( 1,"admin" );
        System.out.println (user.getUserName () + ":" + user.getRoleName ());
    }

    @Test
    public void login(){
        User user = userMapper.selectOne ( new QueryWrapper<User> ().eq ( "user_id", "admin" ).and ( i -> i.eq ( "user_pwd", "admin" ) ) );
        System.out.println (user.getUserName ());
    }
}
