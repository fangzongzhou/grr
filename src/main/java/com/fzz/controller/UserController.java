package com.fzz.controller;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tuyoo on 2017/3/27.
 */
@RestController
@RequestMapping("user")
@JsonFilter("password")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password
            ) {
        return userService.register(username, password)?"注册成功":"注册失败";
    }

    @RequestMapping("login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session
    ){



        return userService.login(username,password,session)?"登录成功":"登录失败";
    }
    @RequestMapping("getall_users")

    public List<UserEntity> userList() {

        return userService.getAllUsers();
    }
}
