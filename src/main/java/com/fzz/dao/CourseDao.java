package com.fzz.dao;

import com.fzz.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fzz on 2017/4/2.
 */
public interface CourseDao extends JpaRepository<Course,Integer> {
}
