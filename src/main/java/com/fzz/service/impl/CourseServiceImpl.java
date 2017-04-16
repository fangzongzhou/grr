package com.fzz.service.impl;

import com.fzz.dao.CoursrDao;
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
    CoursrDao coursrDao;
    @Override
    public Course add(String name, String type, User instructor) {
        return null;
    }

    @Override
    public Course delete(int courseid) {
        return null;
    }

    @Override
    public Course modify() {
        return null;
    }

    @Override
    public Course query(int courseid) {
        return null;
    }

    @Override
    public List<Course> list() {
        return coursrDao.findAll();
    }
}
