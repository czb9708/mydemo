package com.msb.web.controller;

import com.msb.api.code.SystemCode;
import com.msb.api.commons.ResponseResult;
import com.msb.api.commons.ResponseResultFactory;
import com.msb.api.commons.SystemUtils;
import com.msb.web.dao.Cuser;
import com.msb.web.service.CuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * @author: zebin
 * @Date: 2022/12/4 - 12 - 04 - 23:43
 * @Description: com.msb.web.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class CuserController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CuserService cuserService;

    @RequestMapping("/login")
    public String login(Cuser cuser, HttpSession session){
        //非空判断
       /* if (SystemUtils.isNull(cuser.getUserName())){
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_CUSER_LOGIN_USERNAME_NULL,"用户名不能为空");

        }
        if (SystemUtils.isNull(cuser.getUserPass())){
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_CUSER_LOGIN_USERPASS_NULL,"用户密码不能为空");

        }
        Cuser result = cuserService.login(cuser);
        if (SystemUtils.isNull(result)){
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_CUSER_LOGIN_FAIL,"登录失败");
        }else {
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_CUSER_LOGIN_SUCCESS,"登录成功");
        }*/
        Cuser result = cuserService.login(cuser);
        if (SystemUtils.isNull(result)){
            return "fail";
        }else {
            return "success"+session.getId();
        }
    }
    @RequestMapping("/testSession")
    public String getSession(HttpSession session){
        return session.getId();
    }

}
