package com.fzz.service.impl;

import com.fzz.dao.CourseSelectDao;
import com.fzz.dao.CoursrDao;
import com.fzz.dao.UserDao;
import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;
import com.fzz.service.CourseSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by fzz on 2017/4/30.
 */

@Service
public class CourseSelectServiceImpl implements CourseSelectService {
    @Autowired
    CourseSelectDao courseSelectDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CoursrDao coursrDao;

    @Override
    public CourseSelect selectCourse(int userid, int courseid) {
        return courseSelectDao.save(new CourseSelect(userDao.findOne(userid),coursrDao.findOne(courseid)));
    }

    @Override
    public CourseSelect cancelCourse(int courseselectid) {
        CourseSelect courseSelect=courseSelectDao.findOne(courseselectid);
        courseSelectDao.delete(courseselectid);
        return courseSelect;
    }

    @Override
    public List<Course> selectBySb(int userid) {


        return courseSelectDao.sbcourses(userid);
    }

    @Override
    public List<User> allstudents(int courseid) {
        return courseSelectDao.coursestudents(courseid);
    }
}
