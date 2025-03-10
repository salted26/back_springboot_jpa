package com.salted26.back_jpa.mapper;

import com.salted26.back_jpa.dto.UsersDTO;
import com.salted26.back_jpa.entity.Users;

public class UsersMapper {

  public static UsersDTO mapToUsersDTO(Users users) {
    return new UsersDTO(
      users.getId(),
      users.getUsername(),
      users.getPassword(),
      users.getNickname(),
      users.getRole(),
      users.getJoin_date()
    );
  }

  public static Users mapToUsers(UsersDTO usersDTO) {
    return new Users(
      usersDTO.getId(),
      usersDTO.getUsername(),
      usersDTO.getPassword(),
      usersDTO.getNickname(),
      usersDTO.getRole(),
      usersDTO.getJoin_date()
    );
  }

}
