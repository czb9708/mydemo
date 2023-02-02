package com.msb.web.dao;


import javax.persistence.*;

/**
 * @author: zebin
 * @Date: 2022/12/4 - 12 - 04 - 23:21
 * @Description: com.msb.web.dao
 * @version: 1.0
 */
@Entity
@Table(name = "user_cuser")
public class Cuser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cid", nullable = false)
    private Integer cid;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;

    @Override
    public String toString() {
        return "Cuser{" +
                "cid=" + cid +
                ", userName='" + userName + '\'' +
                ", userPass=******'" + '\'' +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
