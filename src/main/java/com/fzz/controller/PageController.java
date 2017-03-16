package com.fzz.controller;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fzz on 2017/2/27.
 */
@Controller
public class PageController {



    @RequestMapping("/fff")
    public String fff() {
        return "ffff";
    }


    @RequestMapping("/ggg")
    public String ggg() {
        return "ggg";
    }
    @RequestMapping("/user/regist")
    public String regist(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password")String password
                         ) {
        System.out.println(username);
        return "ok";
    }


}
