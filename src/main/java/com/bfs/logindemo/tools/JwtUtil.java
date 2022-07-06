package com.bfs.logindemo.tools;


import io.jsonwebtoken.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtUtil {


    public static final long EXPIRE = 1000 * 60 * 60 * 24;

    public static final String SIGNING_KEY ="J0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9";

    public static final String JWT_TOKEN_COOKIE_NAME = "JWT-TOKEN";

    public static String generateToken(String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setSubject(subject)
                .setIssuedAt(now)

                //.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(60).toInstant()))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY);

        return builder.compact();
    }

    public static String getSubject(HttpServletRequest httpServletRequest){
        String token = CookieUtil.getValue(httpServletRequest, JWT_TOKEN_COOKIE_NAME);
        if(token == null) return null;

        Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
        System.out.println(claims.getIssuedAt());

        return claims.getSubject();
    }
}
