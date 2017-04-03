package com.fzz.dao;

import com.fzz.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fzz on 2017/4/2.
 */
public interface RoomDao extends JpaRepository<Room,Integer> {
}
