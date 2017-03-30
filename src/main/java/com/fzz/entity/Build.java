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
}
