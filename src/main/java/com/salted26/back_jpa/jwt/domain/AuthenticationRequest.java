package com.salted26.back_jpa.jwt.domain;

import lombok.Data;

@Data
public class AuthenticationRequest {

  private String email;
  private String password;

}
