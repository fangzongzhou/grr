package com.fzz.controller;

import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;
import com.fzz.service.CourseSelectService;
import com.fzz.service.CourseService;
import com.fzz.service.impl.CourseSelectServiceImpl;
import com.fzz.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    CourseSelectServiceImpl courseSelectService;
    @RequestMapping("creat")
    public Course creat(
        @RequestParam("name")String name,
        @RequestParam("type")String type,
        @RequestParam("instructerid")int instructerid
    ){
        return courseService.add(name,type,instructerid);
    }

    @RequestMapping("all")
    public List<Course> listall(){
        return courseService.list();
    }

    @RequestMapping("select")
    public CourseSelect select(
            @RequestParam("selecterid")int selecterid,
            @RequestParam("courseid")int courseid
    ) {
        return courseSelectService.selectCourse(selecterid,courseid);
    }

    @RequestMapping("students")
    public List<User> students(
            @RequestParam("courseid")int courseid
    ) {
        return courseSelectService.allstudents(courseid);
    }
    @RequestMapping("selected")
    public List<Course> selected(
            @RequestParam("userid")int userid
    ){
        return courseSelectService.selectBySb(userid);
    }
}
