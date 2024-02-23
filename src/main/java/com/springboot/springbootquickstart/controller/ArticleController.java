package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Article;
import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {
  @Resource
  private ArticleService articleService;

  @PostMapping("/list")
  @ResponseBody
  public Result<String> list(Map<String, Object> params) {
    // 验证token
    return Result.success("文章获取成功");
  }

  @GetMapping("/findById")
  @ResponseBody
  public Result findById(Integer id) {
    Article article = articleService.findById(id);
    if (article == null) {
      return Result.error("不存在该文章");
    }
    return Result.success(article);
  }
  @PostMapping("/add")
  @ResponseBody
  public Result add(@RequestBody @Validated(Article.Add.class) Article article) {
    articleService.add(article);
    return Result.success();
  }
  @DeleteMapping("/delete")
  @ResponseBody
  public Result delete(Integer id) {
    Article article = articleService.findById(id);
    if (article == null) {
      return Result.error("不存在该文章");
    }
    articleService.delete(id);
    return Result.success();
  }
  @PutMapping("/update")
  @ResponseBody
  public Result update(@RequestBody @Validated(Article.Update.class) Article article) {
    Integer id = article.getId();
    Article updateArticle = articleService.findById(id);
    if (updateArticle == null) {
      return Result.error("不存在该文章");
    }
    articleService.update(article);
    return Result.success();
  }
}
