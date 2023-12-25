package com.apress.demo.springblog.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    // 根路径跳转到帖子列表页
    registry.addRedirectViewController("/", "/posts");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //添加附加拦截器
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/assets/").addResourceLocations("/resources/assets/");
  }

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    // Do Nothing
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {
    // Add additional formatters here
  }
}
