package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.Category;
import org.apache.ibatis.annotations.*;

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

  @Update("UPDATE category SET category_name=#{categoryName}, category_alias=#{categoryAlias} WHERE id=#{id}")
  void update(Integer id, String categoryName, String categoryAlias);

  @Select("SELECT * FROM category WHERE id=#{id}")
  Category findCategoryById(Integer id);
  @Delete("DELETE FROM category WHERE id=#{id}")
  void delete(Integer id);
}
