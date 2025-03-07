package com.salted26.back_jpa.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

// SpringSecurity 5.4 이하
//public class SecurityConfig extends WebSecurityConfiguration {

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  // SpringSecurity 5.5 이상
  @Bean
  public DefaultSecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
    // 폼 기반 로그인 비활성화
    http.formLogin((login) -> login.disable() );

    // Http 기본 인증 비활성화
    http.httpBasic((httpBasic) -> httpBasic.disable() );

    // CSRF 공격 방어 기능 비활성화
    http.csrf((csrf) -> csrf.disable() );

    // Session 관리 정책 설정
    // Session 인증을 사용하지 않고, JWT를 사용하여 인증하기 떄문에 Session 불필요1
    http.sessionManagement((sessionManagement)
      -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS) );

    return http.build();
  }

  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }


}
