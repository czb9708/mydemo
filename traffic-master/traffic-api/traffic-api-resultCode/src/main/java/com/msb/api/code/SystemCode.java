package com.msb.api.code;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 21:00
 * @Description: com.msb.api.code
 * @version: 1.0
 */

/**
 *                              错误码
 * traffic-system 系统模块     10000 - 15555
 * >
 * > 用户管理		10000 - 10999
 * >
 * > 角色管理		11000 - 11999
 * >
 * > 权限管理		12000 - 12999
 */
public interface SystemCode {


    /**
     * 全局通用
     * 成功码000000
     * 失败码000001
     */
    String SYSTEM_SUCCESS = "000000";
    String SYSTEM_ERROR = "000001";

    /**
     * c端用户管理     01000 - 01099
     * 10000 用户名为空
     *
     *
     */
    String SYSTEM_CUSER_LOGIN_USERNAME_NULL = "01001";
    String SYSTEM_CUSER_LOGIN_USERPASS_NULL = "01002";
    String SYSTEM_CUSER_LOGIN_SUCCESS = "01003";
    String SYSTEM_CUSER_LOGIN_FAIL = "01003";


    /**
     * 用户管理     10000 - 10999
     * 10000 用户名为空
     *
     *
     */

    String SYSTEM_USER_ADD_UNAME_NULL = "10000";
    String SYSTEM_USER_ADD_UPASS_NULL = "10001";
    String SYSTEM_USER_ADD_UPASS_LENGTH_ERROR = "10002";
    String SYSTEM_USER_ADD_UPHONE_NULL = "10003";
    String SYSTEM_USER_ADD_UPHONE_LENGTH_ERROR = "10004";

    String SYSTEM_USER_DEL_ID_NULL = "10020";

    String SYSTEM_USER_UPD_ID_NULL = "10060";
    String SYSTEM_USER_UPD_UNAME_NULL = "10061";
    String SYSTEM_USER_UPD_UPASS_NULL = "10062";


    /**
     * 角色管理		11000 - 11999
     *
     */
    String SYSTEM_ROLE_ADD_RNAME_NULL = "11001";
    String SYSTEM_ROLE_ADD_RTYPE_NULL = "11002";



    /**
     * 权限管理		12000 - 12999
     */

}
