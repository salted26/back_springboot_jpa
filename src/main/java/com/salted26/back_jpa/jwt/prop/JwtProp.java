package com.salted26.back_jpa.jwt.prop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
public class JwtProp {

  @Value("${jwt.secret}")
  private String secretKey;

}
