package com.msb.api.commons;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAUtil {

    /**
     * 生成一堆公私钥
     */
    public static void genKey() throws NoSuchAlgorithmException {

        //构件一个生成公钥私钥 RSA算法生成的对象
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

        //初始化我们的生成器  512起
        keyPairGenerator.initialize(512,new SecureRandom());

        //密钥对
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //获取私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        //获取公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

        //获取私钥字符串
        String privateKeyStr = new String(Base64.encodeBase64(privateKey.getEncoded()));
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()));

        System.out.println("privateKeyStr : " + privateKeyStr);
        System.out.println("publicKeyStr : " + publicKeyStr);

    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        genKey();
    }

}
