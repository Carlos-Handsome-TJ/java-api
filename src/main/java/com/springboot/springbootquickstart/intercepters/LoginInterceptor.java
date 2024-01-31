package com.springboot.springbootquickstart.intercepters;

import com.springboot.springbootquickstart.pojo.Result;
import com.springboot.springbootquickstart.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登录拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) {
    // 令牌验证
    String token = request.getHeader("Authorization");
    try {
      Map<String, Object> claims = JwtUtil.parseToken(token);
      return true;
    } catch (Exception e) {
      response.setStatus(401);
      return false;
    }
  }
}
