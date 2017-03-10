package com.fzz.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fzz on 2017/3/1.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public List<Test> test(
            @RequestParam(value = "username")String username,
            @RequestParam(value = "password")String password
    ) {
        List<Test> list=new ArrayList<Test>();
        Test test1=new Test();
        Test test2=new Test();
        test1.setUsername(username);
        test1.setPassword(password);
        test2.setUsername("fzz");
        test2.setPassword("fangzz");
        list.add(test1);

        list.add(test2);
        System.out.println("qumimei");
        return list;
    }

    @RequestMapping("/upload")
    public String fileupload(@RequestParam(value = "file") MultipartFile file) {
        System.out.println(file.getOriginalFilename());




        System.out.println("wojiufule");
        return "ithafsdfa";
    }

}
