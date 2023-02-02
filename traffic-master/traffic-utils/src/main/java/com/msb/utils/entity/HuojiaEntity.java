package com.msb.utils.entity;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 21:39
 * @Description: com.msb.utils.entity
 * @version: 1.0
 */
public class HuojiaEntity {
    private int sid;
    private String slenght;
    private String sside;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSlenght() {
        return slenght;
    }

    public void setSlenght(String slenght) {
        this.slenght = slenght;
    }

    public String getSside() {
        return sside;
    }

    public void setSside(String sside) {
        this.sside = sside;
    }

    @Override
    public String toString() {
        return "HuojiaEntity{" +
                "sid=" + sid +
                ", slenght='" + slenght + '\'' +
                ", sside='" + sside + '\'' +
                '}';
    }
}
