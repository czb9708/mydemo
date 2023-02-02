package com.msb.ldx.wms.wms.mapper;

import com.msb.ldx.wms.wms.entity.Goodinfo;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 11:17
 * @Description: com.msb.ldx.wms.wms.mapper
 * @version: 1.0
 */
@Mapper
public interface GoodMapper{

    int adds(Goodinfo goods);
}
