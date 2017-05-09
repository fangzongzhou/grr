package com.fzz.service.impl;

import com.fzz.config.Const;
import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import com.fzz.entity.global.Response;
import com.fzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

/**
 * Created by fzz on 2017/3/28.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    //haiyoushei



    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User login(String username, String password, HttpSession httpSession) {
        User user=userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            httpSession.setAttribute(Const.LOGIN_SESSION,user.getId());
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
    public Set<User> getfanslist(HttpSession httpSession) {
        User user=getCurrentUser(httpSession);

        return user.getFans();
    }

    @Override
    //通过对方id关注对方
    public User attationto(int userid,HttpSession httpSession) {
        User attationto=userDao.findOne(userid);
        User currentuser=getCurrentUser(httpSession);
        Set<User> attation=currentuser.getAttation();
        attation.add(attationto);
        currentuser.setAttation(attation);

        return userDao.save(currentuser);
    }

    //获取当前登录的用户
    public User getCurrentUser(HttpSession httpSession) {


        return userDao.findOne((int)httpSession.getAttribute(Const.LOGIN_SESSION));
    }

    public Response modifyusername(int id, String username) {

        System.out.println(userDao.setUserName(username,id));
        return new Response();
    }

    @Override
    public Set<User> getattationlist(HttpSession httpSession) {
        return getCurrentUser(httpSession).getAttation();
    }
}
