package com.ppwq.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.ppwq.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    if (request.getMethod().equals("OPTIONS")) {
      response.setStatus(HttpServletResponse.SC_OK);
      return true;
    }

    response.setCharacterEncoding("utf-8");

    String token = request.getHeader("token");
    if (token != null) {
      boolean result = TokenUtil.verify(token);
      if (result) {
        System.out.println("通过拦截器");
        return true;
      }
    }
    response.setCharacterEncoding("UTF-8");
    response.setContentType("application/json; charset=utf-8");
    try {
      JSONObject json = new JSONObject();
      json.put("code",50000);
      json.put("msg","认证失败，未通过拦截器");
      response.getWriter().append(json.toJSONString());
    } catch (Exception e) {
      e.printStackTrace();
      response.sendError(500);
      return false;
    }
    return false;
  }
}
