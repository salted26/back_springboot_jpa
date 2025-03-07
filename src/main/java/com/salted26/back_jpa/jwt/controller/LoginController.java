package com.salted26.back_jpa.jwt.controller;

import com.salted26.back_jpa.entity.UserRoleType;
import com.salted26.back_jpa.jwt.constants.SecurityConstants;
import com.salted26.back_jpa.jwt.domain.AuthenticationRequest;
import com.salted26.back_jpa.jwt.prop.JwtProp;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class LoginController {

  @Autowired
  private JwtProp jwtProp;

  /**
   * JWT을 생성하는 Login 요청
   * [GET] - /login
   * body : {
   *   "email" : "test@test.co.kr",
   *   "password" : "qwer1234"
   * }
   * @param authReq
   * @return
   * */
  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) {

    log.info("Login request: {}", request);

    String email = request.getEmail();
    String password = request.getPassword();

    List<String> roles = new ArrayList<>();
    roles.add(UserRoleType.USER.name());
    roles.add(UserRoleType.ADMIN.name());

    // 시크릿키 -> byte
    byte[] signingKey = jwtProp.getSecretKey().getBytes();

    // 토큰 생성
    String jwt = Jwts.builder()                         // 시그니처 사용할 미빌키, 알고리즘 설정
      .signWith(Keys.hmacShaKeyFor(signingKey), Jwts.SIG.HS512) // 헤더 설정
      .header().add("typ", SecurityConstants.TOKEN_TYPE) // typ : JWT
      .and()
      .expiration(new Date(System.currentTimeMillis() + 1000*60*60*24*5)) // 토큰 만료 시간 설정(5일)
      .claim("uid", email)  // payload - uid : user
      .claim("rol", roles) // payload - rol : UserRoleType
      .compact();              // 최종적으로 토큰 생성

    log.info("jwt : " + jwt);
//      .signWith(시크릿키, 알고리즘)

    return new ResponseEntity<String>(jwt, HttpStatus.OK);
  }

  // 토큰 해석
  @GetMapping("/user/info")
  public ResponseEntity<?> userInfo(@RequestHeader(name="Authorization") String header) {

    log.info("=============header: {}", header);

    // Authorization : Bearer ${jwt}
    String jwt = header.replace(SecurityConstants.TOKEN_PREFIX, "");

    byte[] signingKey = jwtProp.getSecretKey().getBytes();

    // 토큰 해석
    Jws<Claims> parsedToken = Jwts.parser()
      .verifyWith(Keys.hmacShaKeyFor(signingKey))
      .build()
      .parseClaimsJws(jwt);

    log.info("parsedToken: {}", parsedToken);
    // uid : email
    String email = parsedToken.getPayload().get("email").toString();
    log.info("email: {}", email);

    Claims claims = parsedToken.getPayload();
    Object roles = claims.get("rol");
    log.info("roles: {}", roles);

    return new ResponseEntity<String>(parsedToken.toString(), HttpStatus.OK);
  }
}
