package com.fzz.listener;

import org.springframework.boot.autoconfigure.web.BasicErrorController;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by fzz on 2017/2/27.
 */
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //System.out.println("ServletContex初始化");
        //System.out.println(sce.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //System.out.println("ServletContex销毁");

    }
}
