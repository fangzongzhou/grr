package com.fzz.dao;

import com.fzz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer>{

    public User findByUsername(String userName);


    public List<User> findByUsernameIn(List<String> usernames);

    public List<User> findByIdIn(int[] userids);

    @Modifying
    @Transactional
    @Query("update User set username=:username where id=:id")
    int setUserName(@Param("username")String username,@Param("id")int id);

}
