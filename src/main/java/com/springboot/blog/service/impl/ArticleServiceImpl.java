package com.springboot.blog.service.impl;

import com.springboot.blog.mapper.ArticleMapper;
import com.springboot.blog.pojo.Article;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
  @Resource
  private ArticleMapper articleMapper;

  @Override
  public void add(Article article) {
    // 补充性质
    article.setCreateTime(LocalDateTime.now());
    article.setUpdateTime(LocalDateTime.now());
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    article.setId(id);
    articleMapper.add(article);
  }

  @Override
  public void delete(Integer id) {
    articleMapper.delete(id);
  }

  @Override
  public Article findById(Integer id) {
    Article article = articleMapper.findById(id);
    return article;
  }

  @Override
  public void update(Article article) {
    article.setUpdateTime(LocalDateTime.now());
    articleMapper.update(article);
  }
}
