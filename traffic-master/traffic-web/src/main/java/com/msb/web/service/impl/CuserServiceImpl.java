package com.msb.web.service.impl;

import com.msb.web.dao.Cuser;
import com.msb.web.mapper.CuserMapper;
import com.msb.web.service.CuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zebin
 * @Date: 2022/12/4 - 12 - 04 - 23:54
 * @Description: com.msb.web.service.impl
 * @version: 1.0
 */
@Service
public class CuserServiceImpl implements CuserService {

    @Autowired
    CuserMapper cuserMapper;


    @Override
    public Cuser login(Cuser cuser) {
        return cuserMapper.findByUserNameAndUserPass(cuser.getUserName(), cuser.getUserPass());
    }
}
