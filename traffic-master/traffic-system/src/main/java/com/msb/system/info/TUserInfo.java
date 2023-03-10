package com.msb.system.info;

import com.msb.system.entity.RoleEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "t_user")
public class TUserInfo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long uid;

  @Column
  private String uname;

  @Column
  private String uaccount;

  @Column
  private String upass;

  @Column
  private String umail;

  @Column
  private String uphone;

  @Column
  private String t1;

  @Column
  private String udesc;

  @Column
  private Date utime;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "t_user_role",
          joinColumns = {@JoinColumn(name = "uid",referencedColumnName = "uid")},
          inverseJoinColumns = {@JoinColumn(name = "rid",referencedColumnName = "rid")})

  private List<RoleInfo> roleInfos;

  /**
   * 标注当前用户状态是否可用   0可用   1用户已删 2 锁定 3封号
   */
  @Column
  private int ustatus;

  public List<RoleInfo> getRoleInfos() {
    return roleInfos;
  }

  public void setRoleInfos(List<RoleInfo> roleInfos) {
    this.roleInfos = roleInfos;
  }

  public long getUid() {
    return uid;
  }

  public void setUid(long uid) {
    this.uid = uid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUaccount() {
    return uaccount;
  }

  public void setUaccount(String uaccount) {
    this.uaccount = uaccount;
  }


  public String getUpass() {
    return upass;
  }

  public void setUpass(String upass) {
    this.upass = upass;
  }


  public String getUmail() {
    return umail;
  }

  public void setUmail(String umail) {
    this.umail = umail;
  }


  public String getUphone() {
    return uphone;
  }

  public void setUphone(String uphone) {
    this.uphone = uphone;
  }


  public String getT1() {
    return t1;
  }

  public void setT1(String t1) {
    this.t1 = t1;
  }


  public String getUdesc() {
    return udesc;
  }

  public void setUdesc(String udesc) {
    this.udesc = udesc;
  }

  public Date getUtime() {
    return utime;
  }

  public void setUtime(Date utime) {
    this.utime = utime;
  }

  public int getUstatus() {
    return ustatus;
  }

  public void setUstatus(int ustatus) {
    this.ustatus = ustatus;
  }

  @Override
  public String toString() {
    return "TUserInfo{" +
            "uid=" + uid +
            ", uname='" + uname + '\'' +
            ", uaccount='" + uaccount + '\'' +
            ", umail='" + umail + '\'' +
            ", uphone='" + uphone + '\'' +
            ", t1='" + t1 + '\'' +
            ", udesc='" + udesc + '\'' +
            ", utime=" + utime +
            ", ustatus=" + ustatus +
            '}';
  }
}
