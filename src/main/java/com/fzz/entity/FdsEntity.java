package com.fzz.entity;

import javax.persistence.*;

/**
 * Created by fzz on 2017/3/19.
 */
@Entity
@Table(name = "fds", schema = "db_example", catalog = "")
public class FdsEntity {
    private String fasd;//meisheile
    private String qwer;
    private String gsdfg;

    @Id
    @Column(name = "fasd")
    public String getFasd() {
        return fasd;
    }

    public void setFasd(String fasd) {
        this.fasd = fasd;
    }

    @Basic
    @Column(name = "qwer")
    public String getQwer() {
        return qwer;
    }

    public void setQwer(String qwer) {
        this.qwer = qwer;
    }

    @Basic
    @Column(name = "gsdfg")
    public String getGsdfg() {
        return gsdfg;
    }

    public void setGsdfg(String gsdfg) {
        this.gsdfg = gsdfg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FdsEntity fdsEntity = (FdsEntity) o;

        if (fasd != null ? !fasd.equals(fdsEntity.fasd) : fdsEntity.fasd != null) return false;
        if (qwer != null ? !qwer.equals(fdsEntity.qwer) : fdsEntity.qwer != null) return false;
        if (gsdfg != null ? !gsdfg.equals(fdsEntity.gsdfg) : fdsEntity.gsdfg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = fasd != null ? fasd.hashCode() : 0;
        result = 31 * result + (qwer != null ? qwer.hashCode() : 0);
        result = 31 * result + (gsdfg != null ? gsdfg.hashCode() : 0);
        return result;
    }
}
