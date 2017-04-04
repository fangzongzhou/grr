package com.fzz.service.impl;

import com.fzz.config.Const;
import com.fzz.dao.UserDao;
import com.fzz.entity.User;
import com.fzz.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by tuyoo on 2017/4/4.
 */
@Service
public class RelationServiceImpl implements RelationService {
    @Autowired
    private UserDao userDao;
    @Override
    public boolean haveattation(HttpSession httpSession,int personid) {
        Set<User> attationlist=getattationlist(httpSession);
        for (User user : attationlist) {
            if (user.getId() == personid) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<User> getattationlist(HttpSession httpSession) {
        User user=userDao.findOne((int)httpSession.getAttribute(Const.LOGIN_SESSION));

        return user.getAttation();
    }

    @Override
    public User attationto(int userid, HttpSession httpSession) {
        User user=userDao.findOne((int)httpSession.getAttribute(Const.LOGIN_SESSION));
        User attationto=userDao.findOne(userid);
        Set<User> attationlist=user.getAttation();
        attationlist.add(attationto);
        user.setAttation(attationlist);
        userDao.save(user);
        return attationto;
    }

    @Override
    public User cancelattation(int userid, HttpSession httpSession) {
        User user=userDao.findOne((int)httpSession.getAttribute(Const.LOGIN_SESSION));
        User cancelattation=userDao.findOne(userid);
        Set<User> attationlist=user.getAttation();
        attationlist.remove(cancelattation);
        user.setAttation(attationlist);
        userDao.save(user);
        return cancelattation;
    }
}
