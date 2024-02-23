package com.springboot.blog.service;

import com.springboot.blog.pojo.Category;

import java.util.List;

public interface CategoryService {

  List<Category> list();

  void add(Integer id, String categoryName, String categoryAlia);

  Category findByCategoryName(String categoryName);

  void update(Integer id, String categoryName, String categoryAlias);

  Category findCategoryById(Integer id);

  void delete(Integer id);
}
