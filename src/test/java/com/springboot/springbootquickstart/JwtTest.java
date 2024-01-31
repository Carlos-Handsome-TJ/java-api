package com.springboot.springbootquickstart;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
  @Test
  public void testGen() {
    // 生产jwt
    Map<String, Object> claims = new HashMap<>();
    claims.put("id", 1);
    claims.put("username", "张三");
    String token = JWT.create().withClaim("user", claims) // 载荷
            .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 过期时间
            .sign(Algorithm.HMAC256("carlos-handsome")); // 密钥
    System.out.print(token);
  }

  @Test
  public void testParse() {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9." + "eyJleHAiOjE3MDY3MDg3NDYsInVzZXIiOnsiaWQiOjEsInVzZXJuYW1lIjoi5byg5LiJIn19." + "IMckt1Ze7aa2UKMGOZ9JhnYVDs2yAvYeOlvqu0UqlSQ";
    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("carlos-handsome")).build();
    DecodedJWT decodedJWT = jwtVerifier.verify(token);
    Map<String, Claim> claims = decodedJWT.getClaims();
    System.out.print(claims.get("user")); // 解析密钥
  }
}
