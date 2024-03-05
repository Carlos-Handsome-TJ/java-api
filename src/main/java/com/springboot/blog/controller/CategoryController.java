package com.springboot.blog.controller;

import com.springboot.blog.pojo.Category;
import com.springboot.blog.pojo.Result;
import com.springboot.blog.service.CategoryService;
import com.springboot.blog.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
public class CategoryController {
  @Resource
  private CategoryService categoryService;

  /**
   * 根据id查询分类
   *
   * @param id
   * @return
   */
  @GetMapping("/findCategoryById")
  public Result findCategoryById(Integer id) {
    Category category = categoryService.findCategoryById(id);
    if (category != null) {
      return Result.success(category);
    }
    return Result.error("当前分类不存在");
  }

  /**
   * 查询文章分类
   *
   * @param categoryName
   * @return
   */
  @GetMapping("/findByCategoryName")
  public Category findByCategoryName(String categoryName) {
    Category categoryItem = categoryService.findByCategoryName(categoryName);
    return categoryItem;
  }

  /**
   * 添加文章分类接口
   *
   * @param category
   * @return
   */
  @PostMapping("/add")
  public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
    String categoryName = category.getCategoryName();
    String categoryAlias = category.getCategoryAlias();
    // 校验分类是否已存在
    Category categoryItem = categoryService.findByCategoryName(categoryName);
    if (categoryItem != null) {
      return Result.error("分类已存在");
    }
    Map<String, Object> map = ThreadLocalUtil.get();
    Integer id = (Integer) map.get("id");
    categoryService.add(id, categoryName, categoryAlias);
    return Result.success();
  }

  @DeleteMapping("/delete")
  public Result delete(Integer id) {
    Category category = categoryService.findCategoryById(id);
    if (category == null) {
      return Result.error("分类不存在");
    }
    categoryService.delete(id);
    return Result.success();
  }

  /**
   * 更新分类信息
   *
   * @return
   */
  @PutMapping("/update")
  public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
    Integer id = category.getId();
    String categoryName =  category.getCategoryName();
    String categoryAlias =  category.getCategoryAlias();
    Category updateCategory = categoryService.findCategoryById(id);
    if (updateCategory == null) {
      return Result.error("分类不存在");
    }
    if (updateCategory.getCategoryName().equals(categoryName)) {
      return Result.error("分类名未更改");
    }
    categoryService.update(id, categoryName, categoryAlias);
    return Result.success();
  }

  /**
   * 查询文章列表接口
   *
   * @return
   */
  @GetMapping("/list")
  public Result<List<Category>> list() {
    List<Category> list = categoryService.list();
    // 分页参数
    return Result.success(list);
  }
}