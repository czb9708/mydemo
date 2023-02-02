package com.msb.api.commons;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author: zebin
 * @Date: 2022/10/16 - 10 - 16 - 23:24
 * @Description: com.msb.dongbao.common.util
 * @version: 1.0
 */
public class JwtUtil {
    //盐值
    private static String secret= "raovna";

    //jwt 对用户信息进行编码
    public  static String createToken(String subject){
      String token = Jwts.builder().setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
        return token;
    }

    //对token进行解码
    public static String parseToken(String token){
        Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        String subject = body.getSubject();
        return subject;

    }



}
