package com.msb.utils.web;

import com.msb.utils.entity.HuojiaEntity;
import com.msb.utils.param.ResponseRepository;
import com.msb.utils.param.ResponseResult;
import com.msb.utils.service.JiageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 22:08
 * @Description: com.msb.utils.web
 * @version: 1.0
 */
@RestController
@RequestMapping("/jiage")
public class HuojiaController {

    @Autowired
    JiageService jiageService;

    @RequestMapping("/add")
    public ResponseResult addhj(HuojiaEntity huojiaEntity){
        ResponseResult result = ResponseRepository.getSuccess();
       boolean b = jiageService.addhj(huojiaEntity);
       if (b){
           return result;
       }else {
           return ResponseRepository.getFail();
       }
    }

}
