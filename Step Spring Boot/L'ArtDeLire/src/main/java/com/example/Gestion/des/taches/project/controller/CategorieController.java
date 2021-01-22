package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.service.CategorieService;


@Controller
public class CategorieController {
	
	@Autowired
	private CategorieService categorieService;
	
	@GetMapping("list-categories")
	public String listTasks(Model model) {
		model.addAttribute("categories", categorieService.findAll());
			
		return "views/products/list-categories";
	}
	
	@GetMapping("add-categorie")
	public String addTasks(Model model) {
		model.addAttribute("categories", new Categorie());
		
		return "views/products/add-categorie";
	}
	
	@PostMapping("add-categorie")
	public String addTasks(Model model , Categorie categorie) {
		categorieService.save(categorie);
		return "redirect:/list-categories";
	}
	
	@GetMapping("delete-categorie")
	public String deleteTask(@RequestParam("idCategorie") Long id) {
		categorieService.delete(id);
		
		return "redirect:/list-categories";
	}
	
	@GetMapping("edit-categorie")
	public String editTask(@RequestParam("idCategorie") Long id, Model model, Categorie categorie) {
		model.addAttribute("categories", categorieService.findOne(id).get());
		return "views/products/add-categorie";
	}
}