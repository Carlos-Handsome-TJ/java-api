package com.springboot.springbootquickstart.service;

import com.springboot.springbootquickstart.pojo.Article;

public interface ArticleService {
  void add(Article article);

  void delete(Integer id);

  Article findById(Integer id);

  void update(Article article);
}
