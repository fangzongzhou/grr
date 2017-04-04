package com.fzz.controller;

import com.fzz.entity.User;
import com.fzz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by fzz on 2017/3/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/serqueryname")
    public void setQueryName(
            @RequestParam("username")String username,
            HttpSession httpSession
    ){
        httpSession.setAttribute("queryname",username);
    }

    @RequestMapping("/info")//query user info by session "queryname"
    public User info(
            HttpSession httpSession
    ) {
               String username= (String) httpSession.getAttribute("queryname");
               return userService.findByName(username);
    }
    @RequestMapping("info/{username}")//show user info by quest username
    public User userinfo(
            @PathVariable("username")String username
    ){
                return userService.findByName(username);
    }

    @RequestMapping("/all")//list all user simple info
    public List<User> users() {
        return userService.getAll();
    }

    @RequestMapping("/login")//user login
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

    @RequestMapping("checkusername")//检查用户名是否存在
    public boolean checkUserExist(@RequestParam("username") String username) {
        return userService.checkUserExist(username);
    }


    @RequestMapping("fanslist")//获取粉丝列表
    public Set<User> fanslist(HttpSession httpSession) {
                return userService.getfanslist(httpSession);
    }

    @RequestMapping("attationlist")
    public Set<User> attationlist(HttpSession httpSession) {
                return userService.getattationlist(httpSession);
    }

    @RequestMapping("attationto/{userid}")//通过ID关注其他用户
    public User attationto(
            @PathVariable("userid") int userid,
            HttpSession httpSession

    ){
                return userService.attationto(userid,httpSession);
    }

    @RequestMapping("currentuser")
    public User currentuser(
            HttpSession httpSession
    ){
        return userService.getCurrentUser(httpSession);
    }
}
