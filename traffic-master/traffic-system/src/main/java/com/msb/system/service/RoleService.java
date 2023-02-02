package com.msb.system.service;

import com.msb.system.entity.RoleEntity;

import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/1 - 12 - 01 - 21:02
 * @Description: com.msb.system.service
 * @version: 1.0
 */
public interface RoleService {
    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    boolean addRole(RoleEntity roleEntity);
    /**
     * 查询所有角色
     * @return 角色列表
     */
    List<RoleEntity> findAllRole();
    /**
     * 修改角色信息
     * @return 修改成功true 修改失败false
     */
    boolean upRoleById(RoleEntity roleEntity);
}
