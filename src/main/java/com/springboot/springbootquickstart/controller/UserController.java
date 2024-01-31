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

  /**
   * 用户信息
   *
   * @param token
   * @return
   */
  @GetMapping("/userInfo")
  @ResponseBody
  public Result<User> userInfo(@RequestHeader(name = "Authorization") String token) {
    Map<String, Object> map = JwtUtil.parseToken(token);
    String username = (String) map.get("username");
    User user = userService.findByUserName(username);
    return Result.success(user);
  }

  /**
   * 根据用户名查询用户信息
   *
   * @param username
   * @return
   */
  @RequestMapping("/findByUserName")
  @ResponseBody
  public Result findByUserName(@NotNull String username) {
    User user = userService.findByUserName(username);
    if (user != null) {
      return Result.success(user);
    }
    return Result.error("用户不存在");
  }

  /**
   * 更新用户基本信息
   *
   * @param id
   * @param username
   * @param password
   * @param email
   * @return
   */
  @PutMapping("/update")
  public Result update(Integer id, String username, String password, String email) {
    return Result.success();
  }

  /**
   * 注册
   *
   * @param username
   * @param password
   * @return
   */
  @PostMapping("/register")
  @ResponseBody
  public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
    // 参数校验
    User user = userService.findByUserName(username);
    if (user == null) {
      userService.register(username, password);
      // 生成token
      User sqlUser = userService.findByUserName(username);
      return getResult(sqlUser);
    }
    return Result.error("用户名已被占用");
  }

  /**
   * 登录
   *
   * @param username
   * @param password
   * @return
   */
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
      return getResult(user);
    }
    return Result.error("密码错误");
  }

  @org.jetbrains.annotations.NotNull
  private Result getResult(User user) {
    Map<String, Object> claims = new HashMap<>();
    Map<String, Object> userInfo = new HashMap<>();
    claims.put("id", user.getId());
    claims.put("username", user.getUsername());
    String token = JwtUtil.genToken(claims);
    userInfo.put("userInfo", user);
    userInfo.put("token", token);
    return Result.success(userInfo);
  }
}
