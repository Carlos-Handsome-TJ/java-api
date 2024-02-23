package com.springboot.blog.service;

import com.springboot.blog.pojo.Article;

public interface ArticleService {
  void add(Article article);

  void delete(Integer id);

  Article findById(Integer id);

  void update(Article article);
}
