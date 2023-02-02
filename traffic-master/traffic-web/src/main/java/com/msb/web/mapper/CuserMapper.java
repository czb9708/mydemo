package com.msb.web.mapper;

import com.msb.web.dao.Cuser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: zebin
 * @Date: 2022/12/4 - 12 - 04 - 23:54
 * @Description: com.msb.web.mapper
 * @version: 1.0
 */
public interface CuserMapper extends JpaRepository<Cuser,Integer> {


    public Cuser findByUserNameAndUserPass(String userName,String userPass);
}
