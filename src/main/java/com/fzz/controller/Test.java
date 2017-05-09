package com.fzz.controller;

import com.fzz.entity.global.Response;
import com.fzz.service.UserService;
import com.fzz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.SocketTimeoutException;

/**
 * Created by tuyoo on 2017/4/4.
 */
@RestController
@RequestMapping("/test")
public class Test {
    public Test() {
        System.out.println("weishenme");
    }
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/modifyusername/{id}/{username}")
    public Response modifyusername(
            @PathVariable("id")int id,
            @PathVariable("username")String username

    ){
        System.out.print("xioahuji");
        String xiaohuo0 = "wei";
        String xiaohuo1 = "asdf";
        String xioahuo2 = "zxcv";
        String weishenme = "";
        return userService.modifyusername(id,username);
    }
    @RequestMapping("/asdf")
    public void asdf() {
        System.out.println("xioahuo");
    }
}
