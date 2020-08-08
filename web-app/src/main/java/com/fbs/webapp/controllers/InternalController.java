package com.fbs.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InternalController {
  
  /* ===== Map Home Page ===== */
  @GetMapping("/")
  public String index(){
    return "/internal/index";
  }

  /* ===== Map News Page ===== */
  @GetMapping("/news")
  public String news(){
    return "/internal/news";
  }

  /* ===== Search Function Code Work in Progress ===== 
  @Autowired
  private WorkshopService workshopService;

  private WorkshopRepository workshopRepository;

  public InternalController(WorkshopRepository workshopRepository){
    this.workshopRepository = workshopRepository;
  }
  */

  /* ===== Map Search Page ===== */
  @GetMapping("/search")
  public String search(//Model model
    ){
    // List<Workshops> listWorkshops = workshopService.listAll();
    // model.addAttribute("listWorkshops", listWorkshops);
    return "/internal/search";
  }

  /* ===== Map Contact Page ===== */
  @GetMapping("/contact")
  public String contact(){
    return "/internal/contact";
  }
}