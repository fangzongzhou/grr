package com.fzz.controller;

import com.fzz.entity.global.Response;
import com.fzz.service.UserService;
import com.fzz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tuyoo on 2017/4/4.
 */
@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/modifyusername/{id}/{username}")
    public Response modifyusername(
            @PathVariable("id")int id,
            @PathVariable("username")String username

    ){
        return userService.modifyusername(id,username);
    }
}
