package com.yq.edu.controller;

import com.yq.edu.entity.User;
import com.yq.edu.service.UserService;
import com.yq.edu.vo.UserRoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: edu
 * @description: 核心控制器
 * @author: YeahQing
 * @create: 2019-11-02 21:24
 **/

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    //跳转到登录界面
    @GetMapping
    public String toIndex(){
        return "login";
    }

    //登录(通过用户id和密码)
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "user_id") String userId, @RequestParam(name = "password") String passWord, Model model, HttpSession session){
        User user = userService.loginByUserIdAndPassWord ( userId, passWord );
        if(user == null){
            model.addAttribute ( "error","用户名或密码不正确!" );
            return "login";
        }

        //得到用户角色vo
        UserRoleVo userAndRole = userService.getUserAndRole ( user.getRoleId (),user.getUserId () );
        System.out.println (userAndRole);
        //添加到session域中
        session.setAttribute ( "user", userAndRole );

        return "redirect:/menu/"+userAndRole.getRoleId ();
    }

    //登出 清空session域
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        //清空session域
        session.invalidate ();
        return "redirect:/";
    }

    //修改密码
    @RequestMapping("/modifyPwd")
    public String modifyPwd(){
        return "user/modifyPassWord";
    }

    //ajax接收修改请求
    @ResponseBody
    @PostMapping(value = "/updatePassWord")
    public Map<String,Object> updatePassWord(@ModelAttribute User user, HttpSession session){

        HashMap<String, Object> map = new HashMap<> ();

        userService.updatePassWord ( user );
        UserRoleVo userAndRole = userService.getUserAndRole ( user.getRoleId (),user.getUserId () );
        //之后将新的user添加到session域中
        session.setAttribute ( "user", userAndRole );

        map.put ( "code",200 );
        map.put ( "data","success" );

        return map;
    }


}
