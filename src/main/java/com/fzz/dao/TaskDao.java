package com.fzz.dao;

import com.fzz.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fzz on 2017/4/2.
 */
public interface TaskDao extends JpaRepository<Task,Integer> {
    @Modifying
    @Transactional
    @Query("update User set username=:username where id=:id")
    int setUserName(@Param("username")String username, @Param("id")int id);
}
