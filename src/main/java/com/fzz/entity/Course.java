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

    @ManyToOne
    @JoinColumn(name = "instructor",referencedColumnName = "user_id")
    private User instructor;



//--------------------------------------------------------------------------------------------------------

    public Course() {

    }
    public Course(String name, String type, User instructor) {
        this.setName(name);
        this.setType(type);
        this.setInstructor(instructor);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getInstructor() {
        return instructor;
    }

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }






}
