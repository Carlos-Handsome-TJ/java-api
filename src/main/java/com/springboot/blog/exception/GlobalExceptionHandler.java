package com.springboot.blog.exception;

import com.springboot.blog.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(Exception.class)
  public Result handlerException(Exception e) {
    e.printStackTrace();
    return Result.error(StringUtils.hasLength(e.getMessage()) ? e.getMessage() : "操作错误");
  }
}
