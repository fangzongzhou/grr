package com.fzz.service.impl;

import com.fzz.dao.CourseDao;
import com.fzz.dao.UserDao;
import com.fzz.entity.Course;
import com.fzz.entity.User;
import com.fzz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fzz on 2017/4/16.
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Override
    public Course add(String name, String type, int instructorid) {
        User instructor=userDao.findOne(instructorid);
        return courseDao.save(new Course(name,type,instructor));
    }

    @Override
    public Course delete(int courseid) {
        Course course= courseDao.findOne(courseid);
        courseDao.delete(courseid);
        return course;
    }

    @Override
    public Course modify(int courseid, String name, String type, int instructerid) {
        Course course= courseDao.findOne(courseid);
        course.setName(name);
        course.setType(type);
        course.setInstructor(userDao.findOne(instructerid));
        return courseDao.save(course);
    }

    @Override
    public Course query(int courseid) {
        return courseDao.findOne(courseid);
    }

    @Override
    public List<Course> list() {
        return courseDao.findAll();
    }
}
