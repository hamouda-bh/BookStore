package com.example.Gestion.des.taches.project.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.LivreService;
import com.example.Gestion.des.taches.project.service.UserService;

@Controller
public class HomeController {
      
	@Autowired
	private UserService userService;
	@Autowired
	private CategorieService catService;
	@Autowired
	private LivreService livreService;
	
	
	
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
		
	 
	 @GetMapping("/stats")
	 public String statistique(ModelMap modelMap) {
		 
		 modelMap.put("countUser", userService.countUser());
		 modelMap.put("countLivre", livreService.countLivre());
		 modelMap.put("countCat", catService.countCategorie());
		 
		 return "views/stats";
			 
	 }
	 
	 
	 
}
