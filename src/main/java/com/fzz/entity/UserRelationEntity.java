package com.fzz.entity;

import javax.persistence.*;

/**
 * Created by tuyoo on 2017/3/28.
 */
@Entity
@Table(name = "user_relation", schema = "db_example", catalog = "")
public class UserRelationEntity {
    private Integer user1Id;
    private Integer user2Id;
    private int id;

    @Basic
    @Column(name = "user1_id")
    public Integer getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(Integer user1Id) {
        this.user1Id = user1Id;
    }

    @Basic
    @Column(name = "user2_id")
    public Integer getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(Integer user2Id) {
        this.user2Id = user2Id;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRelationEntity that = (UserRelationEntity) o;

        if (id != that.id) return false;
        if (user1Id != null ? !user1Id.equals(that.user1Id) : that.user1Id != null) return false;
        if (user2Id != null ? !user2Id.equals(that.user2Id) : that.user2Id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user1Id != null ? user1Id.hashCode() : 0;
        result = 31 * result + (user2Id != null ? user2Id.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
