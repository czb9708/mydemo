package com.msb.api.entity;


import java.util.Date;

public class TRoleEntity {

  private long rid;
  private String rname;
  private String rtype;
  private String rdesc;
  private Date rcreatetime;
  private Date rupdatatime;

  public Date getRcreatetime() {
    return rcreatetime;
  }

  public void setRcreatetime(Date rcreatetime) {
    this.rcreatetime = rcreatetime;
  }

  public Date getRupdatatime() {
    return rupdatatime;
  }

  public void setRupdatatime(Date rupdatatime) {
    this.rupdatatime = rupdatatime;
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


  public String getRtype() {
    return rtype;
  }

  public void setRtype(String rtype) {
    this.rtype = rtype;
  }


  public String getRdesc() {
    return rdesc;
  }

  public void setRdesc(String rdesc) {
    this.rdesc = rdesc;
  }

}
