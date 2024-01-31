package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import com.springboot.springbootquickstart.utils.JwtUtil;
import com.springboot.springbootquickstart.utils.Md5Util;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
  @Resource
  private UserService userService;

  @GetMapping("/userInfo")
  public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
    Map<String, Object> map = JwtUtil.parseToken(token);
    String username = (String) map.get("username");
    User user = userService.findByUserName(username);
    return Result.success(user);
  }

  @RequestMapping("/findByUserName")
  @ResponseBody
  public Result findByUserName(@NotNull String username) {
    User user = userService.findByUserName(username);
    if (user != null) {
      return Result.success(user);
    }
    return Result.error("用户不存在");
  }

  @PostMapping("/register")
  @ResponseBody
  public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
    // 参数校验
    User user = userService.findByUserName(username);
    if (user == null) {
      userService.register(username, password);
      // 生成token
      User sqlUser = userService.findByUserName(username);
      Map<String, Object> claims = new HashMap<>();
      claims.put("id", sqlUser.getId());
      claims.put("username", sqlUser.getUsername());
      String token = JwtUtil.genToken(claims);
      return Result.success(token);
    }
    return Result.error("用户名已被占用");
  }

  @PostMapping("/login")
  @ResponseBody
  public Result login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
    User user = userService.findByUserName(username);
    if (user == null) {
      return Result.error("用户不存在");
    }
    String userPsd = Md5Util.getMD5String(password);
    String sqlPsd = user.getPassword();
    if (userPsd.equals(sqlPsd)) {
      // 生成令牌
      Map<String, Object> claims = new HashMap<>();
      claims.put("id", user.getId());
      claims.put("username", user.getUsername());
      String token = JwtUtil.genToken(claims);
      return Result.success(token);
    }
    return Result.error("密码错误");
  }
}
