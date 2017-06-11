package com.fzz.dao;

import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by fzz on 2017/4/30.
 */
public interface CourseSelectDao extends JpaRepository<CourseSelect,Integer> {

    @Query("SELECT u FROM  User u WHERE u.id in \n" +
            "(SELECT cs.selecter.id FROM  CourseSelect cs WHERE cs.course.id=?1)")
    public List<User> coursestudents(int courseid);

    @Query("SELECT c FROM Course c WHERE c.id in \n" +
            "(SELECT cs.course.id FROM CourseSelect cs WHERE cs.selecter.id=?1)")
    public List<Course> sbcourses(int userid);


}
