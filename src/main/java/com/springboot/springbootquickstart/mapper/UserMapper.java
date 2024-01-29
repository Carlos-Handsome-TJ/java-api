package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("select * from user where id=#{id}")
  User findById(Integer id);

  @Select("select * from User where username=#{username}")
  User findByUserName(String username);

  @Select("insert into user(username, password, create_time, update_time)" + "values (#{username}, #{psd}, now(), now())")
  void add(String username, String psd);
}
