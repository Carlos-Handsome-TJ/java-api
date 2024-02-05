package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.ArticleMapper;
import com.springboot.springbootquickstart.pojo.Article;
import com.springboot.springbootquickstart.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Resource
  private ArticleMapper articleMapper;
  @Override
  public void add(Article article) {
    articleMapper.add(article);
  }
}
