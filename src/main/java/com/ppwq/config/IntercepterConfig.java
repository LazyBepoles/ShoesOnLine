package com.ppwq.config;

import com.ppwq.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

  private TokenInterceptor tokenInterceptor;

  public IntercepterConfig(TokenInterceptor tokenInterceptor) {
    this.tokenInterceptor = tokenInterceptor;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    List<String> excludePath = new ArrayList<>();
    excludePath.add("/register"); // 注册
    excludePath.add("/login"); // 登录
    excludePath.add("/logout"); // 登出
    excludePath.add("/static/**"); // 静态资源
    excludePath.add("/getalltype");
    excludePath.add("/getallbrand");
    excludePath.add("/getcommodity");
    excludePath.add("/**");

    registry
        .addInterceptor(tokenInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns(excludePath);
    WebMvcConfigurer.super.addInterceptors(registry);
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry
        .addMapping("/**")
        .allowedOriginPatterns("*")
        .allowedMethods("GET", "POST", "PUT", "DELETE")
        .allowCredentials(true)
        .maxAge(3600)
        .allowedHeaders("*");
  }

}
