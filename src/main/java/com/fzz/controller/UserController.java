package com.fzz.controller;

import com.fzz.entity.User;
import com.fzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/serqueryname")
    public void setQueryName(
            @RequestParam("username")String username,
            HttpSession httpSession
    ){
        httpSession.setAttribute("queryname",username);
    }

    @RequestMapping("/info")
    public User info(
            HttpSession httpSession
    ) {
               String username= (String) httpSession.getAttribute("queryname");
               return userService.findByName(username);
    }

    @RequestMapping("/all")
    public List<User> users() {
        return userService.getAll();
    }

    @RequestMapping("/login")
    public User login(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            HttpSession httpSession
    ){
        return userService.login(username,password,httpSession);
    }
    @RequestMapping("register")
    public User register(
            @RequestParam("username")String username,
            @RequestParam("password")String password
    ){
                return userService.register(username,password);
    }

    @RequestMapping("modify")
    public User modify(
            @RequestParam(required = true, value = "username") String username,
            @RequestParam("password") String password
    ) {
                return userService.modify(username,password);
    }

    @RequestMapping("checkusername")
    public boolean checkUserExist(@RequestParam("username") String username) {
        return userService.checkUserExist(username);
    }

}
