package com.msb.system.entity;


import com.msb.system.info.TUserInfo;

import java.util.Date;
import java.util.List;

public class RoleEntity {

  private long rid;
  private String rname;
  private int rtype;
  private String rdesc;

  private Date createtime;

  private Date updatatime;
  private List<UserEntity> userEntityList;

  public List<UserEntity> getUserEntityList() {
    return userEntityList;
  }

  public void setUserEntityList(List<UserEntity> userEntityList) {
    this.userEntityList = userEntityList;
  }

  public Date getCreatetime() {
    return createtime;
  }

  public void setCreatetime(Date createtime) {
    this.createtime = createtime;
  }

  public Date getUpdatatime() {
    return updatatime;
  }

  public void setUpdatatime(Date updatatime) {
    this.updatatime = updatatime;
  }

  public long getRid() {
    return rid;
  }

  public void setRid(long rid) {
    this.rid = rid;
  }


  public String getRname() {
    return rname;
  }

  public void setRname(String rname) {
    this.rname = rname;
  }


  public int getRtype() {
    return rtype;
  }

  public void setRtype(int rtype) {
    this.rtype = rtype;
  }

  public String getRdesc() {
    return rdesc;
  }

  public void setRdesc(String rdesc) {
    this.rdesc = rdesc;
  }

  @Override
  public String toString() {
    return "RoleEntity{" +
            "rid=" + rid +
            ", rname='" + rname + '\'' +
            ", rtype=" + rtype +
            ", rdesc='" + rdesc + '\'' +
            '}';
  }
}
