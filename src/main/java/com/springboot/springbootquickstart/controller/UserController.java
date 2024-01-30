package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import com.springboot.springbootquickstart.utils.Md5Util;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
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
  @PostMapping("/login")
  public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
    User user = userService.findByUserName(username);
    if(user == null) {
      return Result.error("用户不存在");
    }
    String userPsd = Md5Util.getMD5String(password);
    String sqlPsd = user.getPassword();
    if (userPsd.equals(sqlPsd)) {
      return Result.success("jwt: token令牌，登陆成功");
    }
    return Result.error("密码错误");
  }
}
