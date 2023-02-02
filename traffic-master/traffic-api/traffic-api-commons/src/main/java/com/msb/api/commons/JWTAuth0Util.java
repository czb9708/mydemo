package com.msb.api.commons;

import cn.hutool.crypto.asymmetric.RSA;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.sql.SQLOutput;
import java.util.Calendar;

public class JWTAuth0Util {

    private static final String SECRET = "LDXNBPLUS@MSB";

    //私钥和公钥
    private static final String PRIVATE_KEY_STR = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAopJyS2aqjoOG2ZXXS1LKAdWChrcD4EdvsnFzzpWZdixDVolvAV3n93b78tgNFPLgbMYSltRaSZR37LI3XzP9gQIDAQABAkAx9473i9uaJ+TXlY1xkkWSYLxYiYHAelRjZSlx8lsTjbKESziwHx1paER++8YTKnviIk7bu9ThYyMtk434GREBAiEA648c6sQhqBNyMQjkH2xDx8Ys4yCq8Fe39oYmQ6FiB9ECIQCwrfIGtO60UzpJXdTNjnH6Ot+U1D0a7eiY7cZ1QH62sQIhAN0DUAxtrW53oGKlhvR8rjPYmvEYC4qpou9o+qnl14ahAiBztEam+8DDmSm3uFpPj7S24e1gAypNQ3arCDSKvwT80QIhAORFTywUOXeATWANc3nSHBtbxawO5Xa3l482P5kGu3Bw";
    private static final String PUBLIC_KEY_STR = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKKScktmqo6DhtmV10tSygHVgoa3A+BHb7Jxc86VmXYsQ1aJbwFd5/d2+/LYDRTy4GzGEpbUWkmUd+yyN18z/YECAwEAAQ==";

    /**
     * 根据RSA算法去加密token
     * @param payload
     * @return
     */
    public static String getTokenRSA(java.util.Map<String,String> payload){

        //指定一下过期时间;3天过期;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE , 3);

        //获取一个构件对象;静态内部类
        JWTCreator.Builder builder = JWT.create();

        //将我们的body信息放到我们的需要生成的claim里面
        payload.forEach((k,v)->builder.withClaim(k,v));

        //通过hutool工具类来创建rsa对象
        RSA rsa = new RSA(PRIVATE_KEY_STR,null);

        //获取私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) rsa.getPrivateKey();

        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.RSA256(null, privateKey));
        return token;
    }

    /**
     * 使用rsa的方式解密
     * @param token
     * @return
     * 根据不同的异常来判断当前token到底是什么情况;
     */
    public static DecodedJWT decodedRSA(String token){

        //通过公钥获取我们的rsa的公钥对象
        RSA rsa = new RSA(null,PUBLIC_KEY_STR);
        RSAPublicKey publicKey = (RSAPublicKey) rsa.getPublicKey();

        //jwt的验证对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.RSA256(publicKey, null)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        return decodedJWT;
    }

    /**
     * 获取token
     * @param payload
     * @return
     */
    public static String getToken(java.util.Map<String,String> payload){

        //指定一下过期时间;3天过期;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE , 3);

        //获取一个构件对象;静态内部类
        JWTCreator.Builder builder = JWT.create();

        //将我们的body信息放到我们的需要生成的claim里面
        payload.forEach((k,v)->builder.withClaim(k,v));

        //通过指定签名算法和过期时间生成一个token
        String token = builder.withExpiresAt(calendar.getTime()).sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 将我们的token解析
     * @param token
     * @return
     */
    public static DecodedJWT decodedJWT(String token){
        //构件一个验证jwt token的对象
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        //验证以后获取信息的对象
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        //返回信息对象
        return decodedJWT;
    }


}
