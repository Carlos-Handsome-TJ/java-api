package com.springboot.springbootquickstart.service;

import com.springboot.springbootquickstart.pojo.Category;

public interface CategoryService {
  void add(Integer id, String categoryName, String categoryAlia);

  Category findByCategoryName(String categoryName);
}
