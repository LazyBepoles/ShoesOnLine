package com.ppwq.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ppwq.pojo.User;

import java.util.Date;

public class TokenUtil {

  private static final long EXPIRE_TIME = 15 * 60 * 1000;
  private static final String TOKEN_SECRET = "tokenqkj"; // 密钥盐

  public static String sign(User user) {

    String token = null;
    try {
      Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
      token =
          JWT.create()
              .withIssuer("auth0")
              .withClaim("username", user.getUsername())
              .withExpiresAt(expiresAt)
              // 使用了HMAC256加密算法。
              .sign(Algorithm.HMAC256(TOKEN_SECRET));
    } catch (Exception e) {
      e.printStackTrace();
    }
    return token;
  }

  public static boolean verify(String token) {

    try {
      JWTVerifier verifier =
          JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
      DecodedJWT jwt = verifier.verify(token);
      System.out.println("认证通过：");
      System.out.println("issuer: " + jwt.getIssuer());
      System.out.println("username: " + jwt.getClaim("username").asString());
      System.out.println("过期时间：      " + jwt.getExpiresAt());
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
