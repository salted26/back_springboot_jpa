package com.salted26.back_jpa.repository;

import com.salted26.back_jpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

  @Query(value = "SELECT username, password FROM Users " +
    "WHERE username = :username AND password = :password")
  Optional<Users> findByUsernameWithPassword(
    @Param(value="username") String username,
    @Param(value="password") String password);

  Optional<Users> findByUsername(String username);
}
