package com.msb.baoguan.service.impl;

import com.msb.baoguan.dao.TrafficUntiEntity;
import com.msb.baoguan.repository.untiRepository;
import com.msb.baoguan.service.untiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 23:18
 * @Description: com.msb.baoguan.service.impl
 * @version: 1.0
 */
@Service
public class untiServiceimpl implements untiService {
    @Autowired
    untiRepository untiRepository;
    @Override
    public List<TrafficUntiEntity> queryUntis() {
        List<TrafficUntiEntity> list = untiRepository.findAll();
        return list;
    }
}
