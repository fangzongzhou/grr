package com.fzz.controller;

import com.fzz.entity.Course;
import com.fzz.service.CourseService;
import com.fzz.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tuyoo on 2017/4/3.
 */
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseServiceImpl courseService;
    @RequestMapping("creat")
    public Course creat(

    ){
        return null;
    }

    @RequestMapping("all")
    public List<Course> listall(

    ){

        return courseService.list();
    }
}
