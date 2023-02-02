package com.msb.baoguan.dao;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 22:28
 * @Description: com.msb.baoguan.dao
 * @version: 1.0
 */
@Entity
@Table(name = "traffic_unti", schema = "baoguan", catalog = "")
public class TrafficUntiEntity {
    private int uid;
    private String ucode;
    private String uname;
    private String uuntil;
    private String urate;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "ucode")
    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "uuntil")
    public String getUuntil() {
        return uuntil;
    }

    public void setUuntil(String uuntil) {
        this.uuntil = uuntil;
    }

    @Basic
    @Column(name = "urate")
    public String getUrate() {
        return urate;
    }

    public void setUrate(String urate) {
        this.urate = urate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TrafficUntiEntity that = (TrafficUntiEntity) o;
        return uid == that.uid &&
                Objects.equals(ucode, that.ucode) &&
                Objects.equals(uname, that.uname) &&
                Objects.equals(uuntil, that.uuntil) &&
                Objects.equals(urate, that.urate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, ucode, uname, uuntil, urate);
    }
}
