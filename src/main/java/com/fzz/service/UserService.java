package com.fzz.service;

import com.fzz.entity.User;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Set;

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

    Set<User> getfanslist(HttpSession httpSession);

    User attationto(int userid,HttpSession httpSession);




    Set<User> getattationlist(HttpSession httpSession);
}
