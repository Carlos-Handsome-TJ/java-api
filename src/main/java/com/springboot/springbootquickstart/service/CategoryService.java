package com.springboot.springbootquickstart.service;

import com.springboot.springbootquickstart.pojo.Category;

import java.util.List;

public interface CategoryService {

  List<Category> list();

  void add(Integer id, String categoryName, String categoryAlia);

  Category findByCategoryName(String categoryName);
}
