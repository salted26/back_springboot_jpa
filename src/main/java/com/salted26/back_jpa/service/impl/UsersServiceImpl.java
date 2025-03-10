package com.salted26.back_jpa.service.impl;

import com.salted26.back_jpa.entity.Users;
import com.salted26.back_jpa.repository.UsersRepository;
import com.salted26.back_jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService, UserDetailsService {

  @Autowired
  private UsersRepository usersRepository;

//  @Override
//  public Optional<Users> login(String username, String password) {
//    Optional<Users> users = usersRepository.findByUsernameWithPassword(username, password);
//    return users;
//  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Users> user = usersRepository.findByUsername(username);
    if(user.isPresent()){
      var userObj = user.get();
      return User.builder()
        .username(userObj.getUsername())
        .password(userObj.getPassword())
        .build();
    } else {
      throw new UsernameNotFoundException("User not found");
    }
  }

}
