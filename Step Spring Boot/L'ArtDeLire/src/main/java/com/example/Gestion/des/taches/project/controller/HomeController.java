package com.example.Gestion.des.taches.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
      
	
	 @GetMapping("/home")
	 public String index() {
		 return "index" ;
		 
	 }
	 
	 @RequestMapping(value = { "/", "/login", "index" }, method = RequestMethod.GET)
		public ModelAndView login() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login");
			return modelAndView;
		}
}
