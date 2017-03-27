package com.fzz.dao;

import com.fzz.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by tuyoo on 2017/3/27.
 */
public interface UserDao extends CrudRepository<UserEntity,Integer> {

    @Query("select u from UserEntity u")
    List<UserEntity> getAllUser();
}
