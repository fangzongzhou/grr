package com.fzz.dao;


import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by tuyoo on 2017/4/4.
 * @Description: jpa中使用原生sql
 */
@Service
public class NativeSqlDao {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;


    //直接使用
    public List<Object[]> sqlList(String sql) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query= entityManager.createNativeQuery(sql);
        List<Object[]> list=query.getResultList();
        entityManager.close();
        return list;
    }

    public List sqlObjList(String sql,Class reqclass ) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        Query query=entityManager.createNativeQuery(sql,reqclass);
        List list =query.getResultList();
        entityManager.close();
        return list;
    }
}
