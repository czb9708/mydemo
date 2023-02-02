package com.msb.ldx.wms.wms.service.impl;

import com.msb.ldx.wms.wms.entity.Goodinfo;
import com.msb.ldx.wms.wms.mapper.GoodMapper;
import com.msb.ldx.wms.wms.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 20:48
 * @Description: com.msb.ldx.wms.wms.service.impl
 * @version: 1.0
 */
@Service
public class GoodServiceimpl implements GoodService {

    @Autowired
    GoodMapper goodMapper;
    @Override
    public boolean adds(Goodinfo goods) {
        return goodMapper.adds(goods)>0;
    }
}
