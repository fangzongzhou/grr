package com.fzz.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by fzz on 2017/3/19.
 */
public interface TestDao extends CrudRepository<UserEntity,Integer> {
    @Query("select t from UserEntity t")
    List<UserEntity> getList();
}
