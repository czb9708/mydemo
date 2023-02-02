package com.msb.system.info;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/1 - 12 - 01 - 20:51
 * @Description: com.msb.system.info
 * @version: 1.0
 */
@Entity
@Table(name = "t_role")
public class RoleInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private long rid;
    @Column
    private String rname;
    @Column
    private int rtype;
    @Column
    private String rdesc;


    @Column(name = "create_time")
    private Date createtime;

    @Column(name = "updata_time")
    private Date updatatime;

    @ManyToMany(mappedBy = "roleInfos")
    private List<TUserInfo> tUserInfos;

    public List<TUserInfo> gettUserInfos() {
        return tUserInfos;
    }

    public void settUserInfos(List<TUserInfo> tUserInfos) {
        this.tUserInfos = tUserInfos;
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
        return "RoleInfo{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", rtype=" + rtype +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}
