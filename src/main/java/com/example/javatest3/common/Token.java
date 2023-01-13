package com.example.javatest3.common;

import com.example.javatest3.pojo.MyAdmin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class Token {

    public static final Long JWT_TIME = 60*60*1000L;
    public static final String JWT_KEY = "ljx";

    //生成jwt
    public static String setToken(MyAdmin myAdmin, Long ttlMillis, String uuid){
        Date date = new Date(System.currentTimeMillis());
        if(ttlMillis==null){
            ttlMillis= Token.JWT_TIME;
        }
        Date expired = new Date(System.currentTimeMillis() + ttlMillis);
        String token = Jwts.builder()
                .setId(uuid)
                .setAudience(myAdmin.getAdminName())
                .setIssuer("ljx")
                .setIssuedAt(date)
                .setExpiration(expired)
                .signWith(SignatureAlgorithm.HS256,generalKey())
                .compact();
        return token;
    }

    public static SecretKey generalKey(){
        byte[] encodeKey = Base64.getDecoder().decode(Token.JWT_KEY);
        SecretKeySpec key = new SecretKeySpec(encodeKey, 0, encodeKey.length, "AES");
        return key;
    }

    public static Claims parseJWT(String token){
        Claims claims = Jwts.parser().setSigningKey(generalKey()).parseClaimsJws(token).getBody();
        return claims;
    }

}
