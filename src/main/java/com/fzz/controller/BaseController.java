package com.fzz.controller;

import com.fzz.config.Const;
import com.fzz.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by tuyoo on 2017/4/4.
 */
@Controller
public class BaseController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }


    protected HttpSession getSession() {
        return getRequest().getSession();
    }
    protected User getCurrentUser() {
        return (User)getSession().getAttribute(Const.LOGIN_SESSION);
    }
}
