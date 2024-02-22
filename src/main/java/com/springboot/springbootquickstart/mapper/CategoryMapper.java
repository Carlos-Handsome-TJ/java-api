package com.springboot.springbootquickstart.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CategoryMapper {
  @Insert("INSERT INTO category(create_user, category_name, category_alias, create_time, update_time)" + "VALUES (#{createUser}, #{categoryName}, #{categoryAlia}, now(), now())")
  void addCategory(Integer createUser, String categoryName, String categoryAlia);
}