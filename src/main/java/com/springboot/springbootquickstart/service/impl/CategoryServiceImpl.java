package com.springboot.springbootquickstart.service.impl;

import com.springboot.springbootquickstart.mapper.CategoryMapper;
import com.springboot.springbootquickstart.pojo.Category;
import com.springboot.springbootquickstart.service.CategoryService;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Resource
  private CategoryMapper categoryMapper;

  @Override
  public Category findCategoryById(Integer id) {
    Category category = categoryMapper.findCategoryById(id);
    return category;
  }

  @Override
  public void add(Integer id, String categoryName, String categoryAlia) {
    categoryMapper.add(id, categoryName, categoryAlia);
  }

  @Override
  public Category findByCategoryName(String categoryName) {
    Category categoryItem = categoryMapper.findByCategoryName(categoryName);
    return categoryItem;
  }

  @Override
  public List<Category> list() {
    // 需要增加分页功能
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    List<Category> list = categoryMapper.list(id);
    return list;
  }

  @Override
  public void update(Integer id, String categoryName, String categoryAlias) {
    categoryMapper.update(id, categoryName, categoryAlias);
  }
}
