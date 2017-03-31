package com.fzz.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by fzz on 2017/3/30.
 */
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private int id;
    @Column(nullable = false)
    private int capacity;

    private int floor;

    private String roomTag;
    @JoinColumn(name = "build_id",referencedColumnName = "build_id")
    @ManyToOne
    private Build build;

}
