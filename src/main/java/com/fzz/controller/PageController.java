package com.fzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fzz on 2017/2/27.
 */
@RestController
public class PageController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
