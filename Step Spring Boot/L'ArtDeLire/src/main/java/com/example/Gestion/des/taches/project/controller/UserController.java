package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestion.des.taches.project.model.Task;
import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.RoleService;
import com.example.Gestion.des.taches.project.service.StateService;
import com.example.Gestion.des.taches.project.service.TaskService;
import com.example.Gestion.des.taches.project.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService ;
	@Autowired
	private RoleService roleService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("list-user")
	public String listTasks(Model model) {
		model.addAttribute("users", userService.findAll());
			
		return "views/users/list-user";
	}
	
	@GetMapping("edit-user")
	public String editTask(@RequestParam("idUser") Long id, Model model, Task task) {
		model.addAttribute("users", userService.findOne(id).get());
		model.addAttribute("roles", roleService.findAll());

		return "views/users/edit-user";
	}
	@PostMapping("edit-user")
	public String editTasks(Model model , User user) {
		userService.save(user);
		return "redirect:/list-user";
	}
	@GetMapping("delete-user")
	public String deleteTask(@RequestParam("idUser") Long id) {
		userService.delete(id);
		
		return "redirect:/list-user";
	}
	
	@GetMapping("add-user")
	public String addTasks(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.findAll());
		return "views/users/add-user";
	}
	
	@PostMapping("add-user")
	public String addTasks(Model model , User user) {
		String mdp = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(mdp);
		userService.save(user);
		return "redirect:/list-user";
	}
	
	
	

}
