package com.salted26.back_jpa.jwt.constants;

// Security 밒 jwt 관련된 상수를 관리하는 클래스

/**
 * HTTP
 *  header: {
 *    authorization : Bearer ${jwt}
 *  }
 */

public class SecurityConstants {

  // JWT 토큰을 담을 http 요청 헤더 이름
  public static final String TOKEN_HEADER = "Authorization";
  // header의 접두사
  public static final String TOKEN_PREFIX = "Bearer ";
  // token 타입
  public static final String TOKEN_TYPE = "JWT";

}
