package com.fzz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

/**
 * Created by fzz on 2017/3/28.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id",nullable = false)
    private int id;
    private String gender;
    private String mail;
    private String username;
    @JsonIgnore
    private String password;
    private Integer phoneNumber;
    private Date birthday;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "instructor")
    @JsonIgnore
    private Collection<Course> primaryCourse;
    @OneToMany(mappedBy = "creater")
    @JsonIgnore
    private Collection<Task> createbyme;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "user_task",
            joinColumns = @JoinColumn(name = "operator_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id",referencedColumnName = "id")
    )
    private Collection<Task> tasks2me;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "attation",
            joinColumns = @JoinColumn(name = "attation_from",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "attation_to",referencedColumnName = "user_id")
    )
    private List<User> attation;

    public List<User> getAttation() {
        return attation;
    }

    public void setAttation(List<User> attation) {
        this.attation = attation;
    }

    public List<User> getFans() {
        return fans;
    }

    public void setFans(List<User> fans) {
        this.fans = fans;
    }

    @JsonIgnore
    @ManyToMany

    @JoinTable(
            name = "attation",
            joinColumns = @JoinColumn(name = "attation_to",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "attation_from",referencedColumnName = "user_id")
    )
    private List<User> fans;


    public Collection<Task> getCreatebyme() {
        return createbyme;
    }

    public void setCreatebyme(Collection<Task> createbyme) {
        this.createbyme = createbyme;
    }

    public Collection<Task> getTasks2me() {
        return tasks2me;
    }

    public void setTasks2me(Collection<Task> tasks2me) {
        this.tasks2me = tasks2me;
    }

    public User() {
    }

    public Collection<Course> getPrimaryCourse() {
        return primaryCourse;
    }

    public void setPrimaryCourse(Collection<Course> primaryCourse) {
        this.primaryCourse = primaryCourse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (id != that.id) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (password !=null ? !password.equals(that.birthday) : that.birthday!=null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (password != null ? birthday.hashCode() : 0);
        return result;
    }
}
