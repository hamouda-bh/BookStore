package com.example.Gestion.des.taches.project.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.UserService;

@Controller
public class HomeController {
      
	@Autowired
	private UserService userService;
	
	 @GetMapping("/home")
	 public String index(Model model ,  Principal p , HttpServletRequest request) {
		 
		 
		User connectedUser = userService.findByEmail(p.getName());
		request.getSession().setAttribute("userDB", connectedUser);
		 
		 return "index" ;
		 
	 }
	 
	 @RequestMapping(value = { "/", "/login", "index" }, method = RequestMethod.GET)
		public ModelAndView login() {
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("login");
			return modelAndView;
		}
}
