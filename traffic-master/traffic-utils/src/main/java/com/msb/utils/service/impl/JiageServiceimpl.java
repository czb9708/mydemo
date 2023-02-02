package com.msb.utils.service.impl;

import com.msb.utils.entity.HuojiaEntity;
import com.msb.utils.mapper.HuojiaMapper;
import com.msb.utils.service.JiageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 22:09
 * @Description: com.msb.utils.service.impl
 * @version: 1.0
 */
@Service
public class JiageServiceimpl implements JiageService {

    @Autowired
    HuojiaMapper huojiaMapper;

    @Override
    public boolean addhj(HuojiaEntity huojiaEntity) {
        int i = huojiaMapper.addhj(huojiaEntity);
        if (i>0){
            return true;
        }else {
            return false;
        }
    }
}
