package com.msb.system.service;

import com.msb.api.commons.ResponseResult;
import com.msb.system.entity.UserEntity;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 23:15
 * @Description: com.msb.system.service
 * @version: 1.0
 */
public interface UserService  {

    /**
     *
     * @param userEntity
     * @return true 添加成功 ；false 添加失败
     *
     *
     */
    boolean adduser(UserEntity userEntity);

    /**
     *
     * @param ids 传过来的id是一个删一条，多个删多条
     * @return true 删除成功
     */
    boolean deluser(String ids);

    /**
     *
     * @param userEntity
     * @return true 修改成功
     */
    boolean updUser(UserEntity userEntity);

    /**
     * 查询
     * @return 所有的用户信息
     */
    ArrayList<UserEntity> findAllUSer();

    /**
     * 字符串模糊条件查询
     * @return 符合条件的所有用户信息
     */
    ArrayList<UserEntity> findUserByWhere(UserEntity userEntity);
    /**
     * 按时间查询
     * @return 符合条件的所有用户信息
     */
    ArrayList<UserEntity> findAllByUtimeBetween(String starttime, String endtime);

    /**
     * 分页查询
     * 包括：排序，条件
     * @param userEntity
     * @return
     */
    Map<String , Object> pageQuery(UserEntity userEntity);

}
