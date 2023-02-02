package com.msb.baoguan.controller;

import com.msb.baoguan.dao.TrafficUntiEntity;
import com.msb.baoguan.param.RequestParam;
import com.msb.baoguan.param.ResponseRepository;
import com.msb.baoguan.param.ResponseResult;
import com.msb.baoguan.service.untiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zebin
 * @Date: 2022/12/16 - 12 - 16 - 23:16
 * @Description: com.msb.baoguan.controller
 * @version: 1.0
 */
@RestController
public class unitController {


    @Autowired
    untiService untiService;


    @RequestMapping("/queryUntis")
    public ResponseResult queryUntis(RequestParam param){
        List<TrafficUntiEntity> list = untiService.queryUntis();
        if (0 == list.size()){
            return ResponseRepository.getFail();
        }else {
            return ResponseRepository.getSuccessResult(list);
        }
    }
}
