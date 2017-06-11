package com.fzz.service.impl;

import com.fzz.dao.CourseSelectDao;
import com.fzz.dao.CourseDao;
import com.fzz.dao.MailDao;
import com.fzz.dao.UserDao;
import com.fzz.entity.Course;
import com.fzz.entity.CourseSelect;
import com.fzz.entity.User;
import com.fzz.service.CourseSelectService;
import com.fzz.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.List;

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
    CourseDao courseDao;
    @Autowired
    EmailService emailService;

    @Override
    public CourseSelect selectCourse(int userid, int courseid) {
        User selecter=userDao.findOne(userid);
        Course beSelected = courseDao.findOne(courseid);
        User instructer=beSelected.getInstructor();
        CourseSelect courseSelect = courseSelectDao.save(new CourseSelect(userDao.findOne(userid), courseDao.findOne(courseid)));
        String subject = selecter.getUsername()+"选课通知";
        String mailBody="尊敬的用户："+ instructer.getUsername()+"您好."+"您创建的课程："+beSelected.getName()+"被用户"+selecter.getUsername()+"选择了";
        try {
            emailService.sendEmail(instructer.getMail(),subject,mailBody);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return courseSelect;
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
    public boolean haveSelected(int userid, int courseid) {

        return false;
    }

    @Override
    public List<User> allstudents(int courseid) {
        return courseSelectDao.coursestudents(courseid);
    }
}
