package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.springframework.web.bind.annotation.PostMapping;
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

  @PostMapping("/register")

  public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
    // 参数校验
    User user = userService.findByUserName(username);
    if (user == null) {
      userService.register(username, password);
      return Result.success();
    }
    return Result.error("用户名已被占用");
  }
}
