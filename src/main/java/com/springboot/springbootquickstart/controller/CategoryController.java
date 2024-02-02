package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Category;
import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.service.CategoryService;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Resource
  private CategoryService categoryService;

  @GetMapping("/findByCategoryName")
  public Category findByCategoryName(String categoryName) {
    Category categoryItem = categoryService.findByCategoryName(categoryName);
    return categoryItem;
  }

  @PostMapping("/add")
  public Result add(@RequestBody Map<String, Object> params) {
    String categoryName = (String) params.get("categoryName");
    String categoryAlia = (String) params.get("categoryAlia");
    // 校验分类是否已存在
    Category categoryItem = categoryService.findByCategoryName(categoryName);
    if (categoryItem != null) {
      return Result.error("分类已存在");
    }
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    categoryService.add(id, categoryName, categoryAlia);
    return Result.success();
  }
}
