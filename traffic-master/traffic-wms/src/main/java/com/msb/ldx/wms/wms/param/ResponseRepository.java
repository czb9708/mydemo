package com.msb.ldx.wms.wms.param;


import com.msb.ldx.wms.wms.code.UntiCode;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 23:38
 * @Description: com.msb.baoguan.param
 * @version: 1.0
 */
public class ResponseRepository {

    /**
     * 统一成功返回结果
     * @return
     */
    public static ResponseResult getSuccess(){
        ResponseResult responseResult = new ResponseResult();
        UntiCode untiCode = new UntiCode();
        responseResult.setCode(untiCode.getUNTI_QUERY_SUCCESS());
        responseResult.setMsg(untiCode.getUNTI_QUERY_SUCCESS_MSG());
        return responseResult;
    }
    /**
     * 统一失败返回结果
     * @return
     */
    public static ResponseResult getFail(){

        ResponseResult responseResult = new ResponseResult();
        UntiCode untiCode = new UntiCode();
        responseResult.setCode(untiCode.getUNTI_QUERY_FAIL());
        responseResult.setMsg(untiCode.getUNTI_QUERY_FAIL_MSG());
        return responseResult;
    }
    /**
     * 统一成功返回结果，包括返回的信息
     * @return
     */
    public static ResponseResult getSuccessResult(ResponseResult responseResult){

        return responseResult;
    }
    /**
     * 统一失败返回结果，包括失败原因
     * @return
     */
    public static ResponseResult getFailResult(int untiCode ,String msg){
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(untiCode);
        responseResult.setMsg(msg);
        return responseResult;
    }


}
