package com.fzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fzz on 2017/2/27.
 */
@RestController
public class PageController {

    /*@RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/test")
    public Test test() {
        Test test=new Test();
        test.setName("fasdf");
        test.setId("12");
        return test;
    }*/

    @RequestMapping("/user/regist")
    public String regist(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password")String password
                         ) {
        System.out.println(username);
        return "ok";
    }


}
