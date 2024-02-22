package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
  @Insert("INSERT INTO article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" + "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
  void add(Article article);
}
