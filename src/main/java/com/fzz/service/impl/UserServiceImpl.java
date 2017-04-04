package com.fzz.service.impl;

import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import com.fzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User login(String username, String password, HttpSession httpSession) {
        User user=userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            httpSession.setAttribute("userid",user.getId());
            return user;
        }
        return null;
    }

    @Override
    public boolean checkUserExist(String username) {
        if (userDao.findByUsername(username) != null) {
            return true;
        }
        return false;
    }



    @Override
    public User register(String username, String password) {
        if (!checkUserExist(username)) {
            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            userDao.save(user);
            return user;
        }
        return null;
    }

    @Override
    public User modify(String username, String password) {
        User user=userDao.findByUsername(username);
        user.setPassword(password);
        userDao.save(user);
        return user;
    }

    @Override
    public User findByName(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> getfanslist(HttpSession httpSession) {


        return getCurrentUser(httpSession).getFans();
    }

    @Override
    //通过对方id关注对方
    public User attationto(int userid,HttpSession httpSession) {
        User attationto=userDao.findOne(userid);
        User currentuser=getCurrentUser(httpSession);
        List<User> attation=currentuser.getAttation();
        attation.add(attationto);
        currentuser.setAttation(attation);

        return userDao.save(currentuser);
    }

    //获取当前登录的用户
    private User getCurrentUser(HttpSession httpSession) {

        int userid=(int) httpSession.getAttribute("userid");
        return userDao.findOne(userid);
    }

    @Override
    public List<User> getattationlist(HttpSession httpSession) {
        return getCurrentUser(httpSession).getAttation();
    }
}
