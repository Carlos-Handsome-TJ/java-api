package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.ArticleMapper;
import com.springboot.springbootquickstart.pojo.Article;
import com.springboot.springbootquickstart.service.ArticleService;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
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
}
