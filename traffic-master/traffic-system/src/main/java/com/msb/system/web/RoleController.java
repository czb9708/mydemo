package com.msb.system.web;

import com.msb.api.code.SystemCode;
import com.msb.api.commons.ResponseResult;
import com.msb.api.commons.ResponseResultFactory;
import com.msb.api.commons.SystemUtils;
import com.msb.system.entity.RoleEntity;
import com.msb.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/1 - 12 - 01 - 20:59
 * @Description: com.msb.system.web
 * @version: 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

   Logger logger = LoggerFactory.getLogger(this.getClass());
   //rtype 默认值为0 即此时未指定rtype是什么
  final int ROLE_RTYPE_NOT_NULL = 0;
  final int ZERO = 0;
    @Autowired
    RoleService roleService;

    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    @ResponseBody
    @RequestMapping("/addRole")
    public ResponseResult addRole(RoleEntity roleEntity){
        logger.info("system role addRole controller start");
        if (SystemUtils.isNull(roleEntity.getRname())){
            logger.error(" system role addRole rname is: "+ roleEntity.getRname());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ROLE_ADD_RNAME_NULL,"添加角色名字不能为空");
        }
        logger.info("system role addRole controller rtype"+ roleEntity.getRtype());
        if (ROLE_RTYPE_NOT_NULL == roleEntity.getRtype()){
            logger.error(" system role addRole rtype is: "+ roleEntity.getRtype());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ROLE_ADD_RTYPE_NULL,"添加角色类型不能为空");
        }
        boolean b = roleService.addRole(roleEntity);
        logger.info("system role addRole controller true or false :" + b);
        if (!b){
            logger.info("system role addRole controller error ");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR);
        }
            logger.info("system role addRole controller end");
            return ResponseResultFactory.BuildResponseResult();

    }

    /**
     * 查询所有角色
     * @return 角色列表
     */
    @ResponseBody
    @RequestMapping("/findAllRole")
    public ResponseResult<List<RoleEntity>> findAllRole(){
        List<RoleEntity> allRole = roleService.findAllRole();
        if (allRole.size() == ZERO){
            logger.info("system role findAllRole controller roles is null ");
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR,"无角色信息");
        }
        ResponseResultFactory responseResultFactory = new ResponseResultFactory();
        logger.info("system role findAllRole controller end");
        return responseResultFactory.BuildResponseResult(SystemCode.SYSTEM_SUCCESS,allRole);
    }

    /**
     * 修改角色信息
     * @return true修改成功 false 修改失败
     */
    @ResponseBody
    @RequestMapping("/upRoleById")
    public ResponseResult upRoleById(RoleEntity roleEntity) {
        logger.info("system role upRoleById controller roleid is " + roleEntity.getRid());
        if (SystemUtils.isNull(roleEntity.getRid()) || roleEntity.getRid() == ZERO) {
            logger.error("system role upRoleById controller roleid is null" + roleEntity.getRid());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "未指定角色ID");
        }
        boolean b = roleService.upRoleById(roleEntity);
        if (!b) {
            logger.error("system role upRoleById controller roleid is " + roleEntity.getRid());
            return ResponseResultFactory.BuildResponseResult(SystemCode.SYSTEM_ERROR, "修改失败");
        }
        logger.info("system role upRoleById controller  ok ");
        logger.info("system role upRoleById controller  end ");
        return ResponseResultFactory.BuildResponseResult();
    }
}
