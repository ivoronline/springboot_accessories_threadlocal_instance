package com.ivoronline.springboot_accessories_threadlocal_instance.interceptor;

import com.ivoronline.springboot_accessories_threadlocal_instance.context.UserContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MyInterceptor implements HandlerInterceptor {

  //PROPERTIES
  @Autowired UserContext userContext;
  
  //=========================================================================================================
  // PRE HANDLE
  //=========================================================================================================
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String user = request.getParameter("user");
    userContext.setUser(user);
    return true;
  }

  //=========================================================================================================
  // AFTER COMPLETION
  //=========================================================================================================
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    userContext.clear();
    System.out.println("UserContext.clear()");
  }
  
}