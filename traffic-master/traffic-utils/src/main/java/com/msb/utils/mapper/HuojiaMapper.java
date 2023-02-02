package com.msb.utils.mapper;

import com.msb.utils.entity.HuojiaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zebin
 * @Date: 2023/2/1 - 02 - 01 - 22:10
 * @Description: com.msb.utils.mapper
 * @version: 1.0
 */
@Mapper
public interface HuojiaMapper {
    int addhj(HuojiaEntity huojiaEntity);
}
