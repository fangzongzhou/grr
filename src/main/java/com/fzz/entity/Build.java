package com.fzz.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fzz on 2017/3/31.
 */
@Entity
public class Build {
    @Id
    @Column(name = "build_id")
    private int id;

    private String position;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "id")
    private Collection<Room> rooms;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Collection<Room> rooms) {
        this.rooms = rooms;
    }
}
