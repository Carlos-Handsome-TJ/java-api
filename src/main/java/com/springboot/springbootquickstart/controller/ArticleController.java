package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/article")
public class ArticleController {
  @PostMapping("/list")
  @ResponseBody
  public Result<String> list(@RequestBody Map<String, Object> params) {
    // 验证token
    return Result.success("文章获取成功");
  }
}
