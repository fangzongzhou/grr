package com.fzz.controller;

import com.fzz.entity.User;
import com.fzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("/all")
    public List<User> users() {
        return userService.getAll();
    }

    public User login(
            @RequestParam("username")String username,
            @RequestParam("password")String password
    ){
        return userService.login(username,password);
    }
}
