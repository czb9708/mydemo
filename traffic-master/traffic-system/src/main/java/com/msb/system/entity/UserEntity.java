package com.msb.system.entity;

import com.msb.system.info.RoleInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author: zebin
 * @Date: 2022/11/24 - 11 - 24 - 21:37
 * @Description: com.msb.system.entity
 * @version: 1.0
 */
public class UserEntity implements Serializable {

    private long uid;

    /*@NotEmpty(message = "用户名不为空")
    @Size(min = 4,max = 8,message = "用户名长度设置错误")*/
    private String uname;

    private String uaccount;
    /*@NotEmpty(message = "用户密码不为空")
    @Size(min = 6,max = 12,message = "用户名密码设置错误")*/
    private String upass;

    @Email
    private String umail;

   /* @Size(min = 11,max = 11,message = "用户名号码设置错误")*/
    private String uphone;

    private String t1;

    private String desc;

    private Date utime;

    private int ustatus;


    private String starttime;

    private String endtime;

    private String rolestr;

    private int currentPage = 0; //当前页
    private int pageSize = 3; //每页显示多少条数据
    private String sort; //排序规则优先级,按某字段排序 eg：uaccount,uphone
    private String sortType = "ASC";

    private List<RoleEntity> roleEntityList;

    public String getRolestr() {
        return rolestr;
    }

    public void setRolestr(String rolestr) {
        this.rolestr = rolestr;
    }

    public List<RoleEntity> getRoleEntityList() {
        return roleEntityList;
    }

    public void setRoleEntityList(List<RoleEntity> roleEntityList) {
        this.roleEntityList = roleEntityList;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUstatus() {
        return ustatus;
    }

    public void setUstatus(int ustatus) {
        this.ustatus = ustatus;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", uaccount='" + uaccount + '\'' +
                /*", upass='" + upass + '\'' +*/
                ", umail='" + umail + '\'' +
                ", uphone='" + uphone + '\'' +
                ", t1='" + t1 + '\'' +
                ", desc='" + desc + '\'' +
                ", ustatus=" + ustatus +
                '}';
    }
}
