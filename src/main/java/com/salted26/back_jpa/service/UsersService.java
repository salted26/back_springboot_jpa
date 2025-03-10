package com.salted26.back_jpa.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsersService {

  UserDetails loadUserByUsername(String username);

}
