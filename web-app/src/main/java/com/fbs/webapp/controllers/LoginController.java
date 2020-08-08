package com.fbs.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  /* ===== Get Request for Login Form ===== */
  @GetMapping("/login")
  public String login(){
    return "/external/login";
  }
}