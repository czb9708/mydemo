package com.msb.api.commons;

import java.security.MessageDigest;

/**
 * @author: zebin
 * @Date: 2022/10/25 - 10 - 25 - 18:43
 * @Description: com.msb.dongbao.common.util
 * @version: 1.0
 */
public class Md5Util {
    /**
     * 获取指定字符串的md5值
     * @param dataStr 明文
     * @return String
     */
    public static String md5(String dataStr) {
        try {
            MessageDigest m = MessageDigest.getInstance("md5");
            m.update(dataStr.getBytes("UTF8"));
            byte[] s = m.digest();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                result.append(Integer.toHexString((0x000000FF & s[i]) | 0xFFFFFF00).substring(6));
            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
