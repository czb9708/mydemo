package com.msb.api.commons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: zebin
 * @Date: 2022/12/7 - 12 - 07 - 21:18
 * @Description: com.msb.api.commons
 * @version: 1.0
 */
public class CookieUtil {

    /**
     * 获取cookie的信息
     * @param request
     * @param key
     * @return
     */
    public static String getCookieValue(HttpServletRequest request,String key){
        Cookie[] cookies = request.getCookies();
        try {
            if (null != cookies && cookies.length > 0){
                for (Cookie cookie : cookies){
                    if (key.equals(cookie.getName())){
                        return cookie.getValue();
                    }
                }
            }
        } catch (Exception e) {
            return null;
        }
            return null;
    }

    /**
     * 给指定的cookie设置信息
     * @param cookie
     * @param uri
     * @param maxAge
     * @param domain
     */
    public static void setCookieInfos(Cookie cookie,String uri,int maxAge,String domain){
        cookie.setPath(uri);
        cookie.setDomain(domain);
        cookie.setMaxAge(maxAge);
    }

    /**
     * 给根目录（"/"）指定cookie信息
     * @param key
     * @param maxAge
     * @param domain
     * @return
     */
    public static Cookie getCookieRoot(String key,String value,int maxAge,String domain){
        Cookie cookie = new Cookie(key,value);
        setCookieInfos(cookie,"/",maxAge,domain);
        return cookie;
    }

    /**
     * 给二级域名指定cookie信息
     * @param key
     * @param value
     * @param uri
     * @param maxAge
     * @param domain
     * @return
     */
    public static Cookie getCookie(String key,String value,String uri,int maxAge,String domain){
        Cookie cookie = new Cookie(key,value);
        setCookieInfos(cookie,uri,maxAge,domain);
        return cookie;
    }

    /**
     * 判断是否为ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request){
        boolean result = false;
        if (request.getHeader("x-requested-with") != null && "XMLHttpRequest".equals(request.getHeader("x-requested-with"))){
            result = true;
        }
        return result;
    }
}
