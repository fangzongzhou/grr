package com.fzz.service;

import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getAll() {
        return userDao.findAll();
    }

    public User login(String username, String password, HttpSession httpSession) {
        User user=userDao.findByUsername(username);
        if (user.getPassword().equals(password)) {
            httpSession.setAttribute("userid",user.getId());
            return user;
        }
        return null;
    }

    public boolean checkUserExist(String username) {
        if (userDao.findByUsername(username) != null) {
            return true;
        }
        return false;
    }



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

    public User modify(String username, String password) {
        User user=userDao.findByUsername(username);
        user.setPassword(password);
        userDao.save(user);
        return user;
    }
}
