package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/article")
public class ArticleController {
  @PostMapping("/list")
  @ResponseBody
  public Result<String> list(@NotNull Integer pageNum, @NotNull Integer pageSize) {
    // 验证token
    return Result.success("文章获取成功");
  }
}
