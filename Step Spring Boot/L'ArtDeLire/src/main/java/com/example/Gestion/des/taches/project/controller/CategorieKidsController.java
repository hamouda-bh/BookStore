package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestion.des.taches.project.model.CategorieKids;
import com.example.Gestion.des.taches.project.service.CategorieKidsService;

@Controller
public class CategorieKidsController {
	@Autowired
	private CategorieKidsService categorieKidsService;
	
	@GetMapping("list-categorieskids")
	public String listTasks(Model model) {
		model.addAttribute("categoriekids", categorieKidsService.findAll());
			
		return "views/products/list-categories";
	}
	
	@GetMapping("add-categoriekids")
	public String addTasks(Model model) {
		model.addAttribute("categoriekids", new CategorieKids());
		
		return "views/products/add-categorie";
	}
	
	@PostMapping("add-categoriekids")
	public String addTasks(Model model , CategorieKids categoriekids) {
		categorieKidsService.save(categoriekids);
		return "redirect:/list-categories";
	}
	
	@GetMapping("delete-categoriekids")
	public String deleteTask(@RequestParam("idCategorieKids") Long id) {
		categorieKidsService.delete(id);
		
		return "redirect:/list-categorieskids";
	}
	
	@GetMapping("edit-categoriekids")
	public String editTask(@RequestParam("idCategorieKids") Long id, Model model, CategorieKids categorieKids) {
		model.addAttribute("categorieskids", categorieKidsService.findOne(id).get());
		return "views/products/add-categorie";
	}
}
