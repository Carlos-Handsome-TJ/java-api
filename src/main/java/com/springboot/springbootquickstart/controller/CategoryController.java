package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.service.CategoryService;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Resource
  private CategoryService categoryService;

  @PostMapping("/add")
  public Result add(@RequestBody Map<String, Object> params) {
    String categoryName = (String) params.get("categoryName");
    String categoryAlia = (String) params.get("categoryAlia");
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    categoryService.add(id, categoryName, categoryAlia);
    return Result.success();
  }
}
