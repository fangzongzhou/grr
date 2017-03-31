package com.fzz.dao;

import com.fzz.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fzz on 2017/3/19.
 */
public interface TestDao extends CrudRepository<User,Integer> {
    @Query("select t from User t")
    List<User> getList();
}
