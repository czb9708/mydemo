package com.msb.api.commons;

import javax.lang.model.util.ElementScanner6;

/**
 * @author: zebin
 * @Date: 2022/11/24 - 11 - 24 - 0:56
 * @Description: com.msb.api.commons
 * @version: 1.0
 */
public class SystemUtils {

    /**
     *
     * @param object
     * @return
     * 返回TRUE 表示为空
     * 返回FALSE 表示不为空
     */
    public static boolean isNull(Object object){
        if (object == null ){
            return true;
        }
        return  false;
    }
}
