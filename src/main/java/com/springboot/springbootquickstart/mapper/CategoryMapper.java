package com.springboot.springbootquickstart.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
  @Insert("INSERT INTO category(create_user, category_name, category_alias, create_time, update_time)" +
          "VALUES (#{id}, #{categoryName}, #{categoryAlia}, now(), now())")
  void add(Integer id, String categoryName, String categoryAlia);
}
