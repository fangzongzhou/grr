package com.fzz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fzz on 2017/4/2.
 */
@Entity
public class Task {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "creater_id",referencedColumnName = "user_id")
    private User creater;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "user_task",
            joinColumns = {@JoinColumn(name = "task_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "user_id")})
    private Collection<User> operator;

    private String description;
}
