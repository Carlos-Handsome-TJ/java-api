package com.springboot.springbootquickstart.service;

import com.springboot.springbootquickstart.pojo.User;

public interface UserService {
   User findByUserName(String username);
}
