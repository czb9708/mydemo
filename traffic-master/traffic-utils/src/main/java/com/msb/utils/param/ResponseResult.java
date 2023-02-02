package com.msb.utils.param;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 23:31
 * @Description: com.msb.baoguan.param
 * @version: 1.0
 */
public class ResponseResult<T> {
    private int code;
    private String msg;
    private T t;

    public ResponseResult() {
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, String msg, T t) {
        this.code = code;
        this.msg = msg;
        this.t = t;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
