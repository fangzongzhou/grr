package com.fzz.service;

import com.fzz.entity.Course;
import com.fzz.entity.User;

import java.util.List;
import java.util.Set;

/**
 * Created by tuyoo on 2017/4/3.
 */
public interface CourseService {

    public Course add(String name, String type, User instructor);

    public Course delete(int courseid);

    public Course modify();

    public Course query(int courseid);

    public List<Course> list();
}
