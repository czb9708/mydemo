package com.msb.ldx.wms.wms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 10:42
 * @Description: com.msb.ldx.wms.wms.entity
 * @version: 1.0
 */
public class Goodinfo implements Serializable {

    private int snumber;
    private String sjiage;
    private String sheight;

    public int getSnumber() {
        return snumber;
    }

    public void setSnumber(int snumber) {
        this.snumber = snumber;
    }

    public String getSjiage() {
        return sjiage;
    }

    public void setSjiage(String sjiage) {
        this.sjiage = sjiage;
    }

    public String getSheight() {
        return sheight;
    }

    public void setSheight(String sheight) {
        this.sheight = sheight;
    }
}
