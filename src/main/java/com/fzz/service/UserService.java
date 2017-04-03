package com.fzz.service;

import com.fzz.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by tuyoo on 2017/4/3.
 */
public interface UserService {
    List<User> getAll();

    User login(String username, String password, HttpSession httpSession);

    boolean checkUserExist(String username);

    User register(String username, String password);

    User modify(String username, String password);

    User findByName(String username);

    List<User> getfanslist(HttpSession httpSession);

    User attationto(int userid,HttpSession httpSession);


    List<User> getattationlist(HttpSession httpSession);
}
