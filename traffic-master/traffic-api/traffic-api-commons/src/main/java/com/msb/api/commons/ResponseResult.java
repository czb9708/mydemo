package com.msb.api.commons;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 22:46
 * @Description: com.msb.api.commons
 * @version: 1.0
 */

/**
 * 响应的状态码
 */
public class ResponseResult<T> {
    //状态码
    String resultCode;
    //状态信息
    String resultMsg;
    //响应内容
    T result;
    public ResponseResult(String resultCode) {
        this.resultCode = resultCode;
    }
    public ResponseResult(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
    public ResponseResult(String resultCode,  String resultMsg,T result) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.result = result;
    }
    public ResponseResult(String resultCode, T result) {
        this.resultCode = resultCode;
        this.result = result;
    }
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
