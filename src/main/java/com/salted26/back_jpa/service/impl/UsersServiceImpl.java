package com.salted26.back_jpa.service.impl;

import com.salted26.back_jpa.dto.UsersDTO;
import com.salted26.back_jpa.repository.UsersRepository;
import com.salted26.back_jpa.service.UsersService;
import lombok.Setter;

@Setter
public class UsersServiceImpl implements UsersService {

  private UsersRepository usersRepository;

  @Override
  public UsersDTO login(UsersDTO usersDTO) {
    return null;
  }
}
