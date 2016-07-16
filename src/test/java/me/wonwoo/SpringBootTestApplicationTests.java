package me.wonwoo;

import me.wonwoo.domain.User;
import me.wonwoo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootTestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	public UserService userService;

	@Test
	public void userRestTemplateTest() throws Exception {
		User user = new User(1L, "wonwoo", "wonwoo@test.com", "123123");
		given(userService.findOne(1L)).willReturn(user);
		ResponseEntity<User> userEntity = this.restTemplate.getForEntity("/findOne/{id}", User.class, 1);
		User body = userEntity.getBody();
		assertThat(body.getName()).isEqualTo("wonwoo");
		assertThat(body.getEmail()).isEqualTo("wonwoo@test.com");
		assertThat(body.getPassword()).isEqualTo("123123");
		assertThat(body.getId()).isEqualTo(1);
	}
}
