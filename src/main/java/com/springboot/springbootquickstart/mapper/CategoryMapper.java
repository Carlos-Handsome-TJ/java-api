package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
  @Insert("INSERT INTO category(create_user, category_name, category_alias, create_time, update_time)" +
          "VALUES (#{id}, #{categoryName}, #{categoryAlia}, now(), now())")
  void add(Integer id, String categoryName, String categoryAlia);
  @Select("SELECT * FROM category WHERE category_name=#{categoryName}")
  Category findByCategoryName(String categoryName);
  @Select("SELECT * FROM category WHERE create_user=#{id}")
  List<Category> list(Integer id);
}
