package com.fzz.dao;

import com.fzz.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fzz on 2017/4/2.
 */
public interface TaskDao extends JpaRepository<Task,Integer> {
}
