package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.UserMapper;
import com.springboot.springbootquickstart.pojo.User;
import com.springboot.springbootquickstart.service.UserService;
import com.springboot.springbootquickstart.utils.Md5Util;
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

  @Override
  public void register(String username, String password) {
    String psd = Md5Util.getMD5String(password);
    userMapper.register(username, psd);
  }
}
