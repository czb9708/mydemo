package com.msb.system.repository;

import com.msb.system.entity.UserEntity;
import com.msb.system.info.TUserInfo;

import com.msb.system.service.UserService;
import net.bytebuddy.implementation.Implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * @author: zebin
 * @Date: 2022/11/23 - 11 - 23 - 23:25
 * @Description: com.msb.system.repository
 * @version: 1.0
 */

/**
 * 负责数据查询的接口
 */
public interface Userepository extends JpaRepository<TUserInfo, Long>, JpaSpecificationExecutor<TUserInfo> {



    ArrayList<TUserInfo> findAllByUtimeBetween(Date t1,Date t2);



}
