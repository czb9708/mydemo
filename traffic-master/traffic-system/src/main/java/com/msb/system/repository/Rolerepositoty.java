package com.msb.system.repository;

import com.msb.system.info.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author: zebin
 * @Date: 2022/12/1 - 12 - 01 - 21:03
 * @Description: com.msb.system.repository
 * @version: 1.0
 */

public interface Rolerepositoty extends JpaRepository<RoleInfo,Long>, JpaSpecificationExecutor<RoleInfo> {


}
