package com.fzz.service;

import com.fzz.entity.User;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * Created by tuyoo on 2017/4/4.
 */
public interface RelationService {
    public boolean haveattation(HttpSession httpSession,int personid);

    public Set<User> getattationlist(HttpSession httpSession);

    User attationto(int userid, HttpSession httpSession);

    User cancelattation(int userid,HttpSession httpSession);
}
