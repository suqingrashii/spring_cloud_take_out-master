package com.sy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtils
{
    private static final String SING = "!qsxqw#sdsdf^ssdwe";
    public static String getToken(Map<String,Object> map)
    {
        Calendar insatnce = Calendar.getInstance();
        insatnce.add(Calendar.DATE,7);

        JWTCreator.Builder builder = JWT.create();

        map.forEach((k, v) -> {
            if (v instanceof Long)
            {
                builder.withClaim(k,(Long)v);
            }
            else if (v instanceof String)
            {
                builder.withClaim(k,(String)v);
            }
        });

        String token = builder.withExpiresAt(insatnce.getTime()).sign(Algorithm.HMAC256(SING));
        return token;
    }

    public static DecodedJWT verify(String token)
    {
        try {
            DecodedJWT verify = JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
            return verify;
        }catch (Exception e)
        {
            return null;
        }
    }
}
