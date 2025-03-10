package com.salted26.back_jpa.security;

import com.salted26.back_jpa.service.UsersService;
import com.salted26.back_jpa.service.impl.UsersServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

  @Autowired
  private UsersServiceImpl usersService;

  @Bean
  public UserDetailsService usersDetailService() {
    return usersService;
  }

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(usersService);
    return provider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf(AbstractHttpConfigurer::disable)
      .formLogin(httpForm -> {
      httpForm.loginPage("/login");
    }).authorizeHttpRequests(registry -> {
        registry.requestMatchers(
          "/api/board/**", "/api/user/**", "/css/**", "/js/**")
          .permitAll();
        registry.anyRequest().authenticated();
      }).httpBasic(Customizer.withDefaults())
      .build();
  }
}
