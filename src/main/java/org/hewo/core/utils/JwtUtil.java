package org.hewo.core.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.noear.snack.core.utils.StringUtil;

import java.util.Date;

/**
 * JWT工具类
 */
public class JwtUtil {

    /**
     * 两个常量： 过期时间；秘钥
     */
    public static final long EXPIRE = 15 * 60 * 1000;
    public static final String SECRET = "ukc8BDbRigUDaY6pZFfWus2jZWLPHO";

    public static String sign(String userId,String userCode){
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS2256")
                .setSubject("hewo")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("userId", userId)
                .claim("userCode", userCode)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public static boolean verify(String jwtStr){
        if (StringUtil.isEmpty(jwtStr)) {
            return false;
        }
        try{
            //验证token
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtStr);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static String getUserId(String jwtStr){
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtStr).getBody();
        return body.get("userId",String.class);
    }

    public static String getUserCode(String jwtStr){
        Claims body = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwtStr).getBody();
        return body.get("userCode",String.class);
    }
}
