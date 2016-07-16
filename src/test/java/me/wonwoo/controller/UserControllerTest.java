package me.wonwoo.controller;

import me.wonwoo.domain.User;
import me.wonwoo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
/**
 * Created by wonwoo on 2016. 7. 16..
 */
@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

  @Autowired
  private MockMvc mvc;

  @MockBean
  public UserService userService;

  @Test
  public void userTest() throws Exception {
    given(userService.findOne(1L)).willReturn(new User(1L, "wonwoo", "wonwoo@test.com", "123123"));
    mvc.perform(get("/findOne/{id}", 1L).accept(MediaType.APPLICATION_JSON))
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.id", is(1)))
      .andExpect(jsonPath("$.name", is("wonwoo")))
      .andExpect(jsonPath("$.email", is("wonwoo@test.com")))
      .andExpect(jsonPath("$.password", is("123123")))
      .andExpect(content().json("{'id':1,'name':'wonwoo','email':'wonwoo@test.com','password':'123123'}"));
  }
}