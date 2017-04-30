package com.fzz.service;

import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by fzz on 2017/4/30.
 */
public interface CourseSelectService {
    public CourseSelect selectCourse(int userid,int courseid);
    public CourseSelect cancelCourse(int courseselectid);
    public List<Course> selectBySb(int userid);
    public List<User> allstudents(int courseid);


}
