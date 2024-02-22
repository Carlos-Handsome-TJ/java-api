package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.CategoryMapper;
import com.springboot.springbootquickstart.service.CategoryService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Resource
  CategoryMapper categoryMapper;
  @Override
  public void addCategory(Integer createUser, String categoryName, String categoryAlia) {
    categoryMapper.addCategory(createUser, categoryName, categoryAlia);
  }
}
