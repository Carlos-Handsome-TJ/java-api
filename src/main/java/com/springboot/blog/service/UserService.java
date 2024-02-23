package com.springboot.blog.service;

import com.springboot.blog.pojo.User;

public interface UserService {
  User findByUserName(String username);

  void register(String username, String password);

  void update(User user);

  void updateAvatar(String avatarUrl, Integer id);
  void updatePwd(Integer id, String newPwd);
}
