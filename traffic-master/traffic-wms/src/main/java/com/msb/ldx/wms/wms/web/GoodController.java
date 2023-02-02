package com.msb.ldx.wms.wms.web;

import com.msb.ldx.wms.wms.entity.Goodinfo;
import com.msb.ldx.wms.wms.param.ResponseRepository;
import com.msb.ldx.wms.wms.param.ResponseResult;
import com.msb.ldx.wms.wms.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 10:45
 * @Description: com.msb.ldx.wms.wms.web
 * @version: 1.0
 */
@RestController
@RequestMapping("/Good")
public class GoodController {

   @Autowired
   GoodService goodService;

    /**
     * 添加货架信息
     * @param goods
     * @return 货架信息是否添加成功
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseResult addGood( Goodinfo goods){
         ResponseResult responseResult = ResponseRepository.getSuccess();

        //非空判断

        boolean adds = goodService.adds(goods);
        return responseResult;

    }
}
