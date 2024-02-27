package com.springboot.blog.mapper;

import com.springboot.blog.pojo.Article;
import com.springboot.blog.pojo.PageBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
  @Insert("INSERT INTO article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" + "VALUES (#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, now(), now())")
  void add(Article article);
  @Delete("DELETE FROM article WHERE id=#{id}")
  void delete(Integer id);
  @Select("SELECT * FROM article WHERE id=#{id}")
  Article findById(Integer id);
  @Update("UPDATE article SET title=#{title}, content=#{content}, cover_img=#{coverImg}, state=#{state}, category_id=#{categoryId} WHERE id=#{id}")
  void update(Article article);

  List<Article> list(Integer categoryId, Integer state);
}
