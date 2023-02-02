package com.msb.system.web;


import com.msb.api.code.SystemCode;
import com.msb.api.commons.ResponseResult;
import com.msb.api.commons.ResponseResultFactory;
import com.msb.api.commons.SystemUtils;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.TUserInfo;
import com.msb.system.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 23:14
 * @Description: com.msb.system.web
 * @version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(this.getClass());
    final int USERPASS_LENGTH = 8;
    final int USERID_ID_ZEAR = 0;

    @Autowired
    private UserService userService;

    /**
     * 用户添加
     *
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/adduser")
    public ResponseResult adduser(UserEntity userEntity) {
        logger.info("User adduser" + userEntity);
        logger.info("User adduser" + userEntity.getUname());
        if (null == userEntity.getUname() || userEntity.getUname().trim().equals("")) {
            logger.error("userEntity Uname is null or ''");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_ADD_UNAME_NULL, "用户名为空");
        }
        if (null == userEntity.getUpass()) {
            logger.error("userEntity Upass is null");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_ADD_UPASS_NULL, "用户密码为空");
        }
        if (userEntity.getUpass().length() < USERPASS_LENGTH) {
            logger.error("useEntity Upass length error");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_ADD_UPASS_LENGTH_ERROR, "用户密码长度6-8");
        }

        //省略其他判断
        //对用户密码加密

        userEntity.setUpass(DigestUtils.md5DigestAsHex(userEntity.getUpass().getBytes()));
        boolean adduser = userService.adduser(userEntity);

        /**
         * true 添加成功
         * flase 添加失败
         */
        if (adduser) {
            logger.info("User adduser success");
            return ResponseResultFactory.BuildResponseResult();
        }
        logger.error("User adduser fail");
        return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "添加用户失败");
    }

    /**
     * 用户删除
     *
     * @param uid
     * @return
     */
    @ResponseBody
    @RequestMapping("/deluser")
    public ResponseResult deluser(String uid) {
        logger.info("User deluser id is" + uid);
        if (SystemUtils.isNull(uid)) {
            logger.error("User deluser ids is null");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_DEL_ID_NULL, "用户id为空");
        }

        boolean b = userService.deluser(uid);

        if (b) {
            logger.info("User deluser success");
            return ResponseResultFactory.BuildResponseResult();
        }
        logger.error("User deluser fail");
        return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "删除用户失败");
    }


    /**
     * 用户修改
     *
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/updUser")
    public ResponseResult updUser(UserEntity userEntity) {

        logger.info("User updUser" + userEntity);
        logger.info("User updUser id :  " + userEntity.getUid());
        if (SystemUtils.isNull(userEntity)) {
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "修改用户失败");
        }
        if (USERID_ID_ZEAR == userEntity.getUid() || SystemUtils.isNull(userEntity.getUid())) {
            logger.error("userEntity updUser uid is null or ''");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_UPD_ID_NULL, "用户id错误");
        }
        if (null == userEntity.getUname() || userEntity.getUname().trim().equals("")) {
            logger.error("userEntity updUser Uname is null or ''");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_UPD_UNAME_NULL, "用户名不可修改为空");
        }
        if (null == userEntity.getUpass()) {
            logger.error("userEntity updUser Upass is null");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_USER_UPD_UPASS_NULL, "用户密码不可修改为空");
        }

        boolean b = userService.updUser(userEntity);
        if (b) {
            logger.info("User updUser success");
            return ResponseResultFactory.BuildResponseResult();
        }
        logger.error("User updUser fail");
        return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "修改用户失败");
    }

    /**
     * 查询所有用户
     * @return
     */
    @ResponseBody
    @RequestMapping("/findAllUser")
    public ResponseResult<List<UserEntity>> findAllUser(){
        logger.info(" User findAllUser controller start");
        ArrayList<UserEntity> allUSer = userService.findAllUSer();
        logger.info(" User findAllUser findAllUser controller allUser  :  " + allUSer);
        ResponseResultFactory responseResultFactory = new ResponseResultFactory();
        logger.info(" User findAllUser controller end");
        return responseResultFactory.BuildResponseResult(SystemCode.SYSTEM_SUCCESS, allUSer);

    }

    /**
     * 条件查询
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserByWhere")
    public ResponseResult<List<UserEntity>> findUserByWhere(UserEntity userEntity){
        ArrayList<UserEntity> userEntities = userService.findUserByWhere(userEntity);
        if (userEntities.size() == 0){
            logger.error("userEntity findUserByWhere userEntity userEntities size is ： " + userEntities.size());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "未查到结果");
        }
        logger.info(" User findUserByWhere  controller userEntities  :  " + userEntities);
        ResponseResultFactory responseResultFactory = new ResponseResultFactory();
        logger.info(" User findUserByWhere controller end");
        return responseResultFactory.BuildResponseResult(SystemCode.SYSTEM_SUCCESS, userEntities);
    }

    /**
     * 按时间查询符合条件的用户信息
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/findUserBytimeBetween")
    public ResponseResult<List<UserEntity>> findUserBytimeBetween(UserEntity userEntity){
        logger.info(" User findUserBytimeBetween  controller userEntity  :  " + userEntity);
        if (SystemUtils.isNull(userEntity.getStarttime()) || SystemUtils.isNull(userEntity.getEndtime())){
            logger.error("userEntity findUserBytimeBetween userEntity time is error ");
            logger.error("userEntity findUserBytimeBetween userEntity Starttime is ：" + userEntity.getStarttime());
            logger.error("userEntity findUserBytimeBetween userEntity Endtime is ： " + userEntity.getEndtime());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "请输入查询的时间");
        }

        ResponseResultFactory responseResultFactory = new ResponseResultFactory();
        ArrayList<UserEntity> allByUtimeBetween = userService.findAllByUtimeBetween(userEntity.getStarttime(), userEntity.getEndtime());
        logger.info(" User findUserBytimeBetween  controller allByUtimeBetween  :  " + allByUtimeBetween);
        return responseResultFactory.BuildResponseResult(SystemCode.SYSTEM_SUCCESS, allByUtimeBetween);
    }


    /**
     * 查询
     * 分页查询（包括条件查询）
     * @param userEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/pageQuery")
    public ResponseResult pageQuery(UserEntity userEntity){
        ResponseResultFactory responseResultFactory = new ResponseResultFactory();
        Map<String, Object> map = userService.pageQuery(userEntity);
        return responseResultFactory.BuildResponseResult(SystemCode.SYSTEM_SUCCESS, map);
    }
}


