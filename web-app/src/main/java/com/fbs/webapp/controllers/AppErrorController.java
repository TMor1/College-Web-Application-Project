package com.fbs.webapp.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/* ===== Assign and Congigure Error Page for 403/404/500 Requests ===== */
/* ===== Learned from: https://www.baeldung.com/spring-boot-custom-error-page - Listed in References in the Techinal Report ===== */
@Controller
public class AppErrorController implements ErrorController  {
 
  public AppErrorController(){
  }

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request) {
    
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); 
    if (status != null) {
      Integer statusCode = Integer.valueOf(status.toString());
      
      if (statusCode == HttpStatus.FORBIDDEN.value()) {
        return "/internal/error-403";
      }
      if(statusCode == HttpStatus.NOT_FOUND.value()) {
        return "/internal/error-404";
      }
      else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
        return "/internal/error";
      }
    }
    return "/internal/error";
  }

  @Override
  public String getErrorPath() {
    return "/internal/error";
  }
}