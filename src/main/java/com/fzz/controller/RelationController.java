package com.fzz.controller;

import com.fzz.entity.User;
import com.fzz.service.impl.RelationServiceImpl;
import com.fzz.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by tuyoo on 2017/4/3.
 */
@RestController
@RequestMapping("relation")
public class RelationController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RelationServiceImpl relationService;

    //判断该userid是否存在于关注列表中
    @RequestMapping("haveattation/{userid}")
    public boolean haveAttation(
            @PathVariable("userid") int userid,
            HttpSession httpSession
    ) {
        return relationService.haveattation(httpSession,userid);

    }

    @RequestMapping("attationto/{userid}")//通过ID关注其他用户
    public User attationto(
            @PathVariable("userid") int userid,
            HttpSession httpSession

    ){
        return relationService.attationto(userid,httpSession);
    }

    @RequestMapping("cancelattation/{userid}")
    public User cacelattation(
            @PathVariable("userid") int userid,
            HttpSession httpSession
    ){
                return relationService.cancelattation(userid,httpSession);
    }
}
