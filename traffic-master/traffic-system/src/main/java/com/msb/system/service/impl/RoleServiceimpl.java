package com.msb.system.service.impl;

import com.msb.api.commons.SystemUtils;
import com.msb.system.entity.RoleEntity;
import com.msb.system.info.RoleInfo;
import com.msb.system.repository.Rolerepositoty;
import com.msb.system.service.RoleService;
import com.msb.system.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/1 - 12 - 01 - 21:02
 * @Description: com.msb.system.service.impl
 * @version: 1.0
 */
@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    Rolerepositoty rolerepositoty;



    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    @Override
    public boolean addRole(RoleEntity roleEntity) {
        RoleInfo roleInfo = ConvertUtil.roleEntityConvertRoleInfo(roleEntity);
        roleInfo.setCreatetime(new Date());
        RoleInfo save = rolerepositoty.save(roleInfo);

        if (SystemUtils.isNull(save)){
            return false;
        }
        return true;
    }


    /**
     * 查询所有角色
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> findAllRole() {

        List<RoleInfo> roleInfoList = rolerepositoty.findAll();

        List<RoleEntity> roleEntityList = ConvertUtil.roleInfoListConvertRoleEntityList(roleInfoList);

        return roleEntityList;
    }

    @Override
    public boolean upRoleById(RoleEntity roleEntity) {
        RoleInfo roleInfo = null;
        try {
            roleInfo = rolerepositoty.findById(roleEntity.getRid()).get();
        }catch (Exception e){
            return false;
        }
        if (!SystemUtils.isNull(roleEntity.getRtype())){
            roleInfo.setRname(roleEntity.getRname());
        }
        if (!SystemUtils.isNull(roleEntity.getRtype())){
            roleInfo.setRtype(roleEntity.getRtype());
        }
        roleInfo.setUpdatatime(new Date());
        RoleInfo save = rolerepositoty.save(roleInfo);
        if (!SystemUtils.isNull(save)){
            return true;
        }
        return false;
    }


}
