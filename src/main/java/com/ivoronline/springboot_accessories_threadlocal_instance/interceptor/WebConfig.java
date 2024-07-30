package com.ivoronline.springboot_accessories_threadlocal_instance.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  //PROPERTIES
  @Autowired private MyInterceptor myInterceptor;
  
  //=========================================================================================================
  // ADD INTERCEPTORS
  //=========================================================================================================
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(myInterceptor);
  }
  
}