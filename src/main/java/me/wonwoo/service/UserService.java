package me.wonwoo.service;

import lombok.RequiredArgsConstructor;
import me.wonwoo.domain.User;
import me.wonwoo.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by wonwoo on 2016. 7. 16..
 */
@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public User findOne(Long id){
    return userRepository.findOne(id);
  }
}
