package com.salted26.back_jpa.entity;

import lombok.Getter;

@Getter
public enum UserRoleType {

  ADMIN("관리자"),
  USER("유저");

  String role;

  UserRoleType(String role) {
    this.role = role;
  }

  public String value() {
    return role;
  }

}
