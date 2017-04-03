package com.fzz.dao;

import com.fzz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
public interface UserDao extends JpaRepository<User,Integer>{

    public User findByUsername(String userName);


    public List<User> findByUsernameIn(List<String> usernames);

}
