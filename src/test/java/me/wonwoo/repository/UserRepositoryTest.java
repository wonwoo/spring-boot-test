package me.wonwoo.repository;

import me.wonwoo.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by wonwoo on 2016. 7. 16..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository repository;

  @Test
  public void findByNameTest() {
    this.entityManager.persist(new User("wonwoo", "wonwoo@test.com","123123"));
    User user = this.repository.findByname("wonwoo");
    assertThat(user.getName()).isEqualTo("wonwoo");
    assertThat(user.getEmail()).isEqualTo("wonwoo@test.com");
    assertThat(user.getPassword()).isEqualTo("123123");
    assertThat(user.getId()).isEqualTo(1);
  }
}