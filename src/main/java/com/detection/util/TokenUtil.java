package com.detection.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * @Author ding
 * @Date 2021/12/20
 */
public class TokenUtil {

    /**
     * @Describe:生成token
     * @param id:用户id
     * @param sec: 密钥
     * @Date:2021/12/20 20:48
     */
    public static String getToken(String id,String sec){
        String sign=null;
        try{
            Date start = new Date();
            long time=Long.parseLong(PropertiesUtil.getKey("MINUTE"));
            long currentTime = System.currentTimeMillis() + time * 60 * 1000;//一小时有效时间
            Date end = new Date(currentTime);
            sign = JWT.create().withAudience(id).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(sec));
            return sign;
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return sign;
    }
}
