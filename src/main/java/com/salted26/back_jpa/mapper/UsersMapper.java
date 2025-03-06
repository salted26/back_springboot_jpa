package com.salted26.back_jpa.mapper;

import com.salted26.back_jpa.dto.UsersDTO;
import com.salted26.back_jpa.entity.Users;

public class UsersMapper {

  public static UsersDTO mapToUsersDTO(Users users) {
    return new UsersDTO(
      users.getNo(),
      users.getId(),
      users.getPassword(),
      users.getNickname(),
      users.getRole(),
      users.getJoinDate()
    );
  }

  public static Users mapToUsers(UsersDTO usersDTO) {
    return new Users(
      usersDTO.getNo(),
      usersDTO.getId(),
      usersDTO.getPassword(),
      usersDTO.getNickname(),
      usersDTO.getRole(),
      usersDTO.getJoinDate()
    );
  }

}
