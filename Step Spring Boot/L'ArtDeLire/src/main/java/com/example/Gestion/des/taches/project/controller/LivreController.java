package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.model.Task;
import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.LivreService;
import com.example.Gestion.des.taches.project.service.PanierService;
import com.example.Gestion.des.taches.project.service.RoleService;


@Controller
public class LivreController {
	@Autowired
	private LivreService livreService ;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private PanierService panierService;
	
	@GetMapping("list-livres")
	public String listTasks(Model model) {
		model.addAttribute("livres", livreService.findAll());
			
		return "views/products/list-livres";
	}
	@GetMapping("add-livre")
	public String addTasks(Model model) {
		model.addAttribute("livres", new Livre());
		model.addAttribute("categories", categorieService.findAll());
		return "views/products/add-livre";
	}
	
	@PostMapping("add-livre")
	public String addTasks(Model model , Livre livre) {
		livreService.save(livre);
		return "redirect:/list-livres";
	}

	@GetMapping("panierTableL")
	public String addPanier(Model model) {
		model.addAttribute("livres", new Livre());
		return "views/products/panierTable";
	}
	
	@PostMapping("panierTableL")
	public String addPanier(Model model,Livre p) {
		panierService.addLivre(p);
		return "redirect:/panierTableL";
	}
	
	@GetMapping("delete-livre")
	public String deleteTask(@RequestParam("idLivre") Long id) {
		livreService.delete(id);
		
		return "redirect:/list-livres";
	}
	@GetMapping("edit-livre")
	public String editTask(@RequestParam("idLivre") Long id, Model model, Livre livre) {
		model.addAttribute("livres", livreService.findOne(id).get());
		model.addAttribute("categories", categorieService.findAll());

		return "views/products/add-livre";
	}
}
	