package com.springboot.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.springboot.blog.mapper.ArticleMapper;
import com.springboot.blog.pojo.Article;
import com.springboot.blog.pojo.PageBean;
import com.springboot.blog.service.ArticleService;
import com.springboot.blog.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

  // 条件分页列表查询
  @Override
  public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, Integer state) {
    // 1.创建pageBean对象
    PageBean pageList = new PageBean();
    // 2.开启分页查询
    PageHelper.startPage(pageNum, pageSize);
    // 3.调用mapper完成查询
    List<Article> as =  articleMapper.list(categoryId, state);
    Page<Article> p = (Page<Article>) as;
    pageList.setTotal(p.getTotal());
    pageList.setList(p.getResult());
    return pageList;
  }
}
