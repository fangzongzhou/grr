package com.fzz.controller;

import com.fzz.config.Const;
import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;
import com.fzz.service.CourseSelectService;
import com.fzz.service.CourseService;
import com.fzz.service.impl.CourseSelectServiceImpl;
import com.fzz.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
            @RequestParam("name") String name,
            @RequestParam("type") String type,
            @RequestParam("instructerid") int instructerid
    ) {
        return courseService.add(name, type, instructerid);
    }

    @RequestMapping("all")
    public List<Course> listall() {
        return courseService.list();
    }

    @RequestMapping("select")
    public CourseSelect select(
            @RequestParam("selecterid") int selecterid,
            @RequestParam("courseid") int courseid
    ) {
        return courseSelectService.selectCourse(selecterid, courseid);
    }

    @RequestMapping("students")
    public List<User> students(
            @RequestParam("courseid") int courseid
    ) {
        return courseSelectService.allstudents(courseid);
    }

    @RequestMapping("selected")
    public List<Course> selected(
            @RequestParam("userid") int userid
    ) {
        return courseSelectService.selectBySb(userid);
    }

    @RequestMapping("info/{courseid}")
    public ModelAndView info(
            @PathVariable("courseid") int courseid
    ) {
        ModelAndView mv=new ModelAndView("course_info");
        mv.addObject("course",courseService.query(courseid));
        return mv;
    }

    @RequestMapping("setqueryid/{courseid}")
    public void setqueryid(
            @PathVariable("courseid") int courseid,
            HttpSession httpSession
    ) {
        httpSession.setAttribute(Const.QUERY_COURSE_ID, courseid);
    }

    @RequestMapping("getqueryid")
    public int getqueryid(
            HttpSession httpSession
    ) {
        return (int) httpSession.getAttribute(Const.QUERY_COURSE_ID);
    }
    @RequestMapping("test/{courseid}")
    public ModelAndView test(
            @PathVariable("courseid")int courseid,
            Model model
    ){
        ModelAndView mv=new ModelAndView("test");
        mv.addObject("name","grr");
        mv.addObject("course",courseService.query(courseid));

            return mv;
    }
}


