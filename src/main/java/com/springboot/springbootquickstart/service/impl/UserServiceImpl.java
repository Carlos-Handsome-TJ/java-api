package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.UserMapper;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
  @Resource
  private UserMapper userMapper;

  @Override
  public User findByUserName(String username) {
    User user = userMapper.findByUserName(username);
    return user;
  }
}
