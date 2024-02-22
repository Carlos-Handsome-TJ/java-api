package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Category;
import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.service.CategoryService;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Resource
  CategoryService categoryService;
  @GetMapping("/getCategory")
  public Category getCategory() {
    // 查询文章是否添加过
    return null;
  }
  @PostMapping("/addCategory")
  @ResponseBody
  public Result addCategory(@RequestBody @Validated Category category) {
    String categoryName = category.getCategoryName();
    String categoryAlia = category.getCategoryAlia();
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer createUser = (Integer) map.get("id");
    categoryService.addCategory(createUser, categoryName, categoryAlia);
    return Result.success();
  }
}
