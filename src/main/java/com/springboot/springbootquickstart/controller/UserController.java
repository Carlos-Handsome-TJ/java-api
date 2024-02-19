package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import com.springboot.springbootquickstart.utils.JwtUtil;
import com.springboot.springbootquickstart.utils.Md5Util;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.jetbrains.annotations.NotNull;
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
   * @param
   * @return
   */
  @GetMapping("/userInfo")
  @ResponseBody
  public Result<User> userInfo() {
    Map<String, Object> map = ThreadLocalUtil.get();
    String username = (String) map.get("username");
    User user = userService.findByUserName(username);
    if (user != null) {
      return Result.success(user);
    }
    return Result.error("用户不存在");
  }

  /**
   * 根据用户名查询用户信息
   *
   * @param username
   * @return
   */
  @RequestMapping("/findByUserName")
  @ResponseBody
  public Result findByUserName(@NotEmpty String username) {
    User user = userService.findByUserName(username);
    if (user != null) {
      return Result.success(user);
    }
    return Result.error("用户不存在");
  }

  /**
   * 更新用户基本信息
   *
   * @param user
   * @return
   */
  @PutMapping("/update")
  public Result update(@RequestBody @Validated User user) {
    userService.update(user);
    return Result.success();
  }

  /**
   * 更新用户头像
   *
   * @param avatarUrl
   * @return
   */
  @PatchMapping("/updateAvatar")
  public Result updateAvatar(@URL String avatarUrl) {
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    userService.updateAvatar(avatarUrl, id);
    return Result.success();
  }

  @PatchMapping("/updatePwd")
  public Result updatePwd(@RequestBody Map<String, Object> params) {
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    String username = (String) map.get("username");
    User user = userService.findByUserName(username);
    String old_pwd = (String) params.get("oldPwd");
    String new_pwd = (String) params.get("newPwd");
    String re_pwd = (String) params.get("rePwd");
    if (!user.getPassword().equals(Md5Util.getMD5String(old_pwd))) {
      return Result.error("密码错误");
    }
    // 验证密码是否正确
    if (!re_pwd.equals(new_pwd)) {
      // 前端校验新密码和二次输入密码是否一致
      return Result.error("两次密码不一致");
    }
    userService.updatePwd(id, Md5Util.getMD5String(new_pwd));
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
