package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
  @Select("select * from user where username=#{username};")
  User findByUserName(String username);
}
