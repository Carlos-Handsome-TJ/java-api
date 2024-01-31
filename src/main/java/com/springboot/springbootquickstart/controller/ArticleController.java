package com.springboot.springbootquickstart.controller;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
  public Result<String> list(@RequestHeader(name = "Authorization") String token, HttpServletResponse response) {
    // 验证token
    try {
      Map<String, Object> claims = JwtUtil.parseToken(token);
      return Result.success("文章获取成功");
    } catch (Exception e) {
      response.setStatus(401);
      return Result.error("未登录");
    }
  }
}
