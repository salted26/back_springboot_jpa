package com.salted26.back_jpa.dto;

import com.salted26.back_jpa.entity.UserRoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {

  private Long id;
  private String username;
  private String password;
  private String nickname;
  private UserRoleType role;
  private LocalDateTime join_date;

}
