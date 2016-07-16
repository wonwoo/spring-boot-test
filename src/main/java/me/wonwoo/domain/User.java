package me.wonwoo.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by wonwoo on 2016. 7. 16..
 */
@Getter
@Entity
@EqualsAndHashCode
@AllArgsConstructor
public class User {

  User(){
  }

  @Id @GeneratedValue
  private Long id;
  private String name;
  private String email;
  private String password;

  public User(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }
}
