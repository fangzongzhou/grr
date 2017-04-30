package com.fzz.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by fzz on 2017/4/30.
 */
@Entity
@Table(name = "course_select")
public class CourseSelect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "user_id",name = "selecter_id")
    private User selecter;
    @ManyToOne
    @JoinColumn(referencedColumnName = "id",name = "course_id")
    private Course course;
    @Column(nullable = true)
    private double score;

    //---------------------------------------------------------------------
    public CourseSelect(User selecter, Course course) {
        this.setSelecter(selecter);
        this.setCourse(course);
    }

    public CourseSelect() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSelecter() {
        return selecter;
    }

    public void setSelecter(User selecter) {
        this.selecter = selecter;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
