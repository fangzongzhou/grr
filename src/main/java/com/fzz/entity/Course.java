package com.fzz.entity;

import javax.persistence.*;

/**
 * Created by fzz on 2017/3/30.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;




}
