package com.msb.api.commons;


import com.msb.api.code.SystemCode;

/**
 * @author: zebin
 * @Date: 2022/11/24 - 11 - 24 - 0:20
 * @Description: com.msb.api.commons
 * @version: 1.0
 */
public class ResponseResultFactory<T> {

    public static ResponseResult BuildResponseResult(){
        return new ResponseResult(SystemCode.SYSTEM_SUCCESS,"操作成功");
    }

    public static ResponseResult BuildResponseResult(String resultCode){
        return new ResponseResult(resultCode);
    }

    public static ResponseResult BuildResponseResult(String resultCode,String resultMsg){
        return new ResponseResult(resultCode,resultMsg);

    }

    public  ResponseResult<T> BuildResponseResult(String resultCode,String resultMsg,T result ){
        return new ResponseResult(resultCode,resultMsg,result);
    }
    public  ResponseResult<T> BuildResponseResult(String resultCode,T result ){
        return new ResponseResult(resultCode,result);
    }
}
