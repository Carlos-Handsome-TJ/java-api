package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.CategoryMapper;
import com.springboot.springbootquickstart.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Resource
  private CategoryMapper categoryMapper;
  @Override
  public void add(Integer id, String categoryName, String categoryAlia) {
    categoryMapper.add(id, categoryName, categoryAlia);
  }
}
