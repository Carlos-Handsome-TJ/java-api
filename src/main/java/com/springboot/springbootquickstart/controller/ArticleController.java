package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Article;
import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.service.ArticleService;
import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
  @Resource
  private ArticleService articleService;

  @PostMapping("/list")
  @ResponseBody
  public Result<String> list(@NotNull Integer pageNum, @NotNull Integer pageSize) {
    // 验证token
    return Result.success("文章获取成功");
  }

  @PostMapping("/add")
  @ResponseBody
  public Result add(@RequestBody @Validated Article article) {
    articleService.add(article);
    return Result.success();
  }
}
