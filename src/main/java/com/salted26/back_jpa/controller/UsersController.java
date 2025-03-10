package com.salted26.back_jpa.controller;

import com.salted26.back_jpa.entity.Users;
import com.salted26.back_jpa.repository.UsersRepository;
import com.salted26.back_jpa.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UsersController {

  @Autowired
  private UsersRepository usersRepository;

  @Autowired
  private UsersService usersService;

  @PostMapping("/login")
  public ResponseEntity<Users> login(@RequestBody Users user) {
    System.out.println("login");
    String username = user.getUsername();
    usersService.loadUserByUsername(username);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @PostMapping(value="/signup")
  public ResponseEntity<Users> signup(@RequestBody Users user){
    usersRepository.save(user);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
}
