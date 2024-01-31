package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
  @GetMapping("/getArticleById")
  @ResponseBody
  public Result getArticleById(Integer id) {
    return Result.success("文章数据");
  }

  @PostMapping("/list")
  @ResponseBody
  public Result<String> list(@NotNull Integer pageNum, @NotNull Integer pageSize) {
    // 验证token
    return Result.success("文章获取成功");
  }
}
