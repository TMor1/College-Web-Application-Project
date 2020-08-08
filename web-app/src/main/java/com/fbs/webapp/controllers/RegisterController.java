package com.fbs.webapp.controllers;

import com.fbs.webapp.service.UsersDto;
import com.fbs.webapp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {

  /* ### Constructor Fixes User Service Error ### */
  public RegisterController(){

  }

  /* ===== Call Save Method ===== */
  @Autowired
  /* ### Registeration Errors until inserted autowired ### */
  private UsersService usersService;

  public RegisterController(UsersService usersService){
    this.usersService = usersService;
  }
  
  /* ===== Return New User Object for Register Form ===== */
  @ModelAttribute("Users")
  public UsersDto usersDto(){
    return new UsersDto();
  }

  /* ===== Get Request for Registeration Form ===== */
  @GetMapping
  public String register(Model model){
    /* ===== Get User Object ===== */
    model.addAttribute("Users", new UsersDto());
    return "external/register";
  }

  /* ===== Post Request for Registeration Form ===== */
  @PostMapping
  public String regUser(@ModelAttribute("Users") UsersDto usersDto){
    usersService.save(usersDto);
    return "redirect:/register?successful";
  }
}