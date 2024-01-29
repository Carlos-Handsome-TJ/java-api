package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserService userService;

  @RequestMapping("/findByUserName")
  public User findByUserName(String username) {
    User user = userService.findByUserName(username);
    return user;
  }
}
