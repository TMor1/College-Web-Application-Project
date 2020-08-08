package com.fbs.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
  
  /* ===== Admin Panel Page ===== */
  @GetMapping
  public String index(){
    return "/internal/admin/adminPanel";
  }
}