package com.springboot.springbootquickstart.intercepters;

import com.springboot.springbootquickstart.utils.JwtUtil;
import com.springboot.springbootquickstart.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
      // 保存在ThreadLocal中
      ThreadLocalUtil.set(claims);
      return true;
    } catch (Exception e) {
      response.setStatus(401);
      return false;
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    // 清除TreadLocal
    ThreadLocalUtil.remove();
  }
}
