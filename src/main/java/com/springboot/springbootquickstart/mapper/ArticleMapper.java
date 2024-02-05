package com.springboot.springbootquickstart.mapper;

import com.springboot.springbootquickstart.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
  @Insert("INSERT INTO article(title, content, conver_img, state, create_time, update_time)" +
          "VALUES (#{title}, #{content}, #{converImg}, #{state}, now(), now())")
  void add(Article article);
}