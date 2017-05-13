package com.fzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huayu on 2017/5/13.
 */
@Controller
public class ModelTest {

    @RequestMapping("model")
    public ModelAndView ceshi() {


        ModelAndView modelAndView=new ModelAndView("mailhello");
        modelAndView.addObject("username","lixoa");
        return modelAndView;
    }
}
