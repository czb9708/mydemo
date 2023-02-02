package com.msb.system.util;

import com.msb.system.entity.RoleEntity;
import com.msb.system.entity.UserEntity;
import com.msb.system.info.RoleInfo;
import com.msb.system.info.TUserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/3 - 12 - 03 - 22:51
 * @Description: com.msb.system.util
 * @version: 1.0
 */
public class ConvertUtil {
    /**
     *
     * @param roleEntity 转换 roleInfo
     * @return
     */
    public static RoleInfo roleEntityConvertRoleInfo(RoleEntity roleEntity){
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setRid(roleEntity.getRid());
        roleInfo.setRname(roleEntity.getRname());
        roleInfo.setRtype(roleEntity.getRtype());
        roleInfo.setRdesc(roleInfo.getRdesc());
        roleInfo.setCreatetime(roleEntity.getCreatetime());
        roleInfo.setUpdatatime(roleEntity.getUpdatatime());
        return roleInfo;
    }

    /**
     *
     * @param  roleInfo 转换 roleEntity
     * @return
     */
    public static RoleEntity roleInfoConvertRoleEntity(RoleInfo roleInfo){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRid(roleInfo.getRid());
        roleEntity.setRname(roleInfo.getRname());
        roleEntity.setRtype(roleInfo.getRtype());
        roleEntity.setRdesc(roleInfo.getRdesc());
        roleEntity.setCreatetime(roleInfo.getCreatetime());
        roleEntity.setUpdatatime(roleInfo.getUpdatatime());
        if (null != roleInfo.gettUserInfos() && roleInfo.gettUserInfos().size() > 0 && roleInfo.gettUserInfos().get(0).getRoleInfos() == null) {
            roleEntity.setUserEntityList(tUserInfoListConvertUserEntityList(roleInfo.gettUserInfos()));
        }
        return roleEntity;
    }
    /**
     *
     *  roleInfo集合 转换 roleEntity集合
     * @return
     */
    public static List<RoleEntity> roleInfoListConvertRoleEntityList(List<RoleInfo> roleInfoList){
        List<RoleEntity> roleEntityList = new ArrayList<>();
        for (RoleInfo roleInfo : roleInfoList){
            roleEntityList.add(roleInfoConvertRoleEntity(roleInfo));
        }
        return roleEntityList;
    }

    /**
     *
     * @param userEntity 转换 TUserInfo
     * @return
     */
    public static TUserInfo userEntityConvertTUserInfo(UserEntity userEntity){
        TUserInfo tUserInfo = new TUserInfo();
        tUserInfo.setUname(userEntity.getUname());
        tUserInfo.setT1(userEntity.getT1());
        tUserInfo.setUaccount(userEntity.getUaccount());
        tUserInfo.setUdesc(userEntity.getDesc());
        tUserInfo.setUid(userEntity.getUid());
        tUserInfo.setUmail(userEntity.getUmail());
        //查询没必要连密码也查出来
         tUserInfo.setUpass(userEntity.getUpass());
        tUserInfo.setUphone(userEntity.getUphone());
        tUserInfo.setUstatus(userEntity.getUstatus());
        tUserInfo.setUtime(userEntity.getUtime());
        return tUserInfo;
    }

    /**
     *
     * @param  tUserInfo 转换 UserEntity
     * @return
     */
    public static UserEntity tUserInfoConvertUserEntity(TUserInfo tUserInfo){
        UserEntity userEntity = new UserEntity();
        userEntity.setUname(tUserInfo.getUname());
        userEntity.setT1(tUserInfo.getT1());
        userEntity.setUaccount(tUserInfo.getUaccount());
        userEntity.setDesc(tUserInfo.getUdesc());
        userEntity.setUid(tUserInfo.getUid());
        userEntity.setUmail(tUserInfo.getUmail());
        //查询没必要连密码也查出来
        //userEntity.setUpass(tUserInfo.getUpass());
        userEntity.setUphone(tUserInfo.getUphone());
        userEntity.setUstatus(tUserInfo.getUstatus());
        userEntity.setUtime(tUserInfo.getUtime());
        if (null != tUserInfo.getRoleInfos() ) {
            userEntity.setRoleEntityList(roleInfoListConvertRoleEntityList(tUserInfo.getRoleInfos()));
        }
        return userEntity;
    }
    /**
     *
     *  tUserInfoList集合 转换 UserEntity集合
     * @return
     */
    public static ArrayList<UserEntity> tUserInfoListConvertUserEntityList(List<TUserInfo> tUserInfoList){
        List<UserEntity> userEntityList = new ArrayList<>();
        for (TUserInfo tUserInfo : tUserInfoList){
            userEntityList.add(tUserInfoConvertUserEntity(tUserInfo));
        }
        return (ArrayList<UserEntity>) userEntityList;
    }
}
