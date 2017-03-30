package com.fzz.service;

import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public User login(String username, String password) {
        return null;
    }
}
