package com.springboot.blog.mapper;

import com.springboot.blog.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
  @Select("SELECT * FROM user WHERE username=#{username}")
  User findByUserName(String username);
  @Insert("INSERT INTO user(username, password, create_time, update_time)" + "VALUES (#{username}, #{password}, now(), now())")
  void register(String username, String password);
  @Update("UPDATE user SET nickname=#{nickname},email=#{email}, update_time=now() WHERE id=#{id}")
  void update(User user);
  @Update("UPDATE user SET user_pic=#{avatarUrl} WHERE id=#{id}")
  void updateAvatar(String avatarUrl, Integer id);
  @Update("UPDATE user SET password=#{newPwd} WHERE id=#{id}")
  void updatePwd(Integer id, String newPwd);
}
