package com.fzz.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by fzz on 2017/2/22.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory=null;
    private static ThreadLocal threadLocal=new ThreadLocal();

    private HibernateUtil() {

    }
    static {
        sessionFactory=new Configuration().configure().buildSessionFactory();
    }

    //新开一个session
    public static Session openSession() {
        return sessionFactory.openSession();
    }

    /*
    得到跟线程相关的session
    * */
    public static Session getCurrentSession() {
        Session session= (Session) threadLocal.get();
        if (session == null) {
            session=sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
    }

}
