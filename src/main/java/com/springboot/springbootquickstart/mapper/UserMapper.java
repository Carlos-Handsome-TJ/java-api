package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM user WHERE username=#{username}")
  User findByUserName(String username);

  @Select("INSERT INTO user(username, password, create_time, update_time)" + "VALUES (#{username}, #{password}, now(), now())")
  void register(String username, String password);
}
