package com.fzz.dao;

import com.fzz.entity.Build;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fzz on 2017/4/2.
 */
public interface BuildDao extends JpaRepository<Build,Integer> {
}
