package com.example.Gestion.des.taches.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
      
	
	 @GetMapping("/")
	 public String index() {
		 return "index" ;
		 
	 }
	 
	 @GetMapping("/logins")
	 public String login() {
		 return "logins";
	 }
}
