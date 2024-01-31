package com.springboot.springbootquickstart.config;

import com.springboot.springbootquickstart.intercepters.LoginInterceptor;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Resource
  private LoginInterceptor loginInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册登录拦截器，登录、注册取消拦截
    registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login", "/user/register");
  }
}
