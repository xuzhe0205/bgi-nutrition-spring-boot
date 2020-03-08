package com.health.nutrition.common.util;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {
    private static Algorithm algorithm;

    static {
        RSAPublicKey publicKey = getPublicKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDShVgX01DQH2zZKFRuQmZgochI0ISF8WoM16JuGPtPAWrO6+igLXDGC1Yc7DI9NcGQ9pLL0483qoOy3sovv670/S1TxbGgcjVKJ9eXJSBdSgjtdktqmWA/jX6r5jV4zYJc5Fbf9L2zjus/ybVjZvoPpmU7zEvxUaOE0ZoBsC0I6QIDAQAB");
        RSAPrivateKey privateKey = null;
        algorithm = Algorithm.RSA256(publicKey, privateKey);
    }

    /**
     * 校验access_token的合法性
     *
     * @param
     * @return
     */
    public static Map <String, Object> verify(HttpServletRequest req) {
        Map <String, Object> m = null;
        try {
            String accessToken = req.getHeader("Authorization");
            if (accessToken != null) {
                if (!accessToken.startsWith("Bearer ")) {
                    return null;
                }
                accessToken = accessToken.replaceFirst("Bearer ", "");
                JWTVerifier veri = JWT.require(algorithm).acceptLeeway(5).acceptExpiresAt(5).build();
                DecodedJWT jwt = veri.verify(accessToken);
                m = new HashMap <String, Object>();
                m.put("username", jwt.getSubject());
                m.put("id", jwt.getClaim("hid").asString());
                req.setAttribute("userInfo", m);
                return m;
            }
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            return null;
        }
        return null;
    }


    /**
     * 校验access_token的合法性
     *
     * @param accessToken
     * @return
     */
    public static boolean verify(String accessToken) {
        if (null == accessToken) {
            return false;
        }
        boolean rs = false;
        try {
            JWTVerifier veri = JWT.require(algorithm).acceptLeeway(5).acceptExpiresAt(5).build();
            veri.verify(accessToken);
            rs = true;
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            return rs;
        }
        return rs;
    }


    /**
     * 从accessToken中获得用户基本信息userid,username
     *
     * @param accessToken
     * @return
     */
    public static Map <String, String> getUserInfo(String accessToken) {
        Map <String, String> rs = new HashMap <String, String>();
        try {
            accessToken = accessToken.replaceFirst("Bearer ", "");
            JWTVerifier veri = JWT.require(algorithm).acceptLeeway(5).acceptExpiresAt(5).build();
            DecodedJWT jwt = veri.verify(accessToken);
            rs.put("username", jwt.getSubject());
            rs.put("id", jwt.getClaim("hid").asString());
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
            return null;
        }
        return rs;
    }

    private static RSAPublicKey getPublicKey(String publicKeyStr) {
        try {
            // 对公钥解密
            byte[] publicKeyBytes = decryptBase64(publicKeyStr);
            // 取得公钥
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = factory.generatePublic(keySpec);
            return (RSAPublicKey) publicKey;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] decryptBase64(String key) {
        return Base64.getDecoder().decode(key);
    }

}
