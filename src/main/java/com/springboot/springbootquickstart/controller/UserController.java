package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserService userService;

  @PostMapping("/register")
  public Result register(String username, String password) {
    User user = userService.findByUserName(username);
    if (user == null) {
      userService.register(username, password);
      return Result.success();
    } else {
      return Result.error("用户名已被占用");
    }
  }
}
