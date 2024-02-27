package com.springboot.blog.service;

import com.springboot.blog.pojo.Article;
import com.springboot.blog.pojo.PageBean;

public interface ArticleService {
  void add(Article article);

  void delete(Integer id);

  Article findById(Integer id);

  void update(Article article);

  PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, Integer state);
}
