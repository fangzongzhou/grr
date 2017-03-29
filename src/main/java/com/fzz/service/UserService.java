package com.fzz.service;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fzz.dao.UserDao;
import com.fzz.entity.UserEntity;
import com.fzz.util.AccountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tuyoo on 2017/3/27.
 */
@Service
@JsonFilter("password")

public class UserService {
    @Autowired
    private UserDao userDao;

    public boolean register(String username, String password) {
        if (checkNewUser(username, password)) {
            UserEntity userEntity=new UserEntity();
            userEntity.setUsername(username);
            password= AccountUtil.to48PassChar(password);
            userEntity.setPassword(password);
            userDao.save(userEntity);
        }
        else{
            return false;
        }
        return true;
    }

    private boolean checkNewUser(String username, String password) {
        List<UserEntity> userslist= (List<UserEntity>) userDao.findAll();
        Iterator<UserEntity> iterator=userslist.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    //通过用户名查询用户
    private UserEntity findUser8Username(String username) {
        List<UserEntity> userslist= (List<UserEntity>) userDao.findAll();
        Iterator<UserEntity> iterator=userslist.iterator();
        UserEntity userEntity;
        while (iterator.hasNext()) {
            userEntity=iterator.next();
            if (userEntity.getUsername().equals(username)) {
                return userEntity;
            }
        }
        return null;
    }

    //用户登录
    public boolean login(
            String username,
            String password,
            HttpSession session
    ){
        UserEntity userEntity;
        String db_password=AccountUtil.to48PassChar(password);
        if ((userEntity=findUser8Username(username)) != null && userEntity.getPassword().equals(db_password)) {
            session.setAttribute("userid",userEntity.getId());
            return true;
        }
        return false;
    }


    public List<UserEntity> getAllUsers() {
                List<UserEntity> allusers = userDao.getAllUser();
                return allusers;
    }




}
