package me.wonwoo.repository;

import me.wonwoo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wonwoo on 2016. 7. 16..
 */
public interface UserRepository extends JpaRepository<User, Long> {
  User findByname(String name);
}
