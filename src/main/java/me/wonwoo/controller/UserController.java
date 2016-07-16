package me.wonwoo.controller;

import lombok.RequiredArgsConstructor;
import me.wonwoo.domain.User;
import me.wonwoo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonwoo on 2016. 7. 16..
 */
@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/findOne/{id}")
  public User user(@PathVariable Long id){
    return userService.findOne(id);
  }
}
