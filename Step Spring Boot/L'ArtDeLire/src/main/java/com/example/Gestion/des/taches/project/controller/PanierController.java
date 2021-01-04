package com.example.Gestion.des.taches.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.CommandeService;
import com.example.Gestion.des.taches.project.service.LivreService;
import com.example.Gestion.des.taches.project.service.PanierService;

@Controller
public class PanierController {

	@Autowired
	private PanierService panierService;
	@Autowired
	private LivreService livreService ;
	@Autowired
	private CommandeService commandeService;
	
	@GetMapping("panierTable")
	public String listTasks(Model model) {
		model.addAttribute("paniers", panierService.findAll());
			
		return "views/products/panierTable";
	}
	
	@GetMapping("add-panier")
	public String addTasks(Model model) {
		model.addAttribute("paniers", new Panier());
		
		return "views/products/panierTable";
	}
	
	@PostMapping("add-panier")
	public String addTasks(Model model , Panier panier) {
		panierService.save(panier);
		return "redirect:/panierTable";
	}
	
	@GetMapping("delete-panier")
	public String deleteTask(@RequestParam("id_panier") Long id) {
		panierService.delete(id);
		
		return "redirect:/panierTable";
	}
	@GetMapping("edit-panier")
	public String editTask(@RequestParam("id_panier") Long id, Model model, Panier panier) {
	//	model.addAttribute("livres", livreService.findOne(id).get());
		model.addAttribute("paniers", panierService.findOne(id).get());
		return "views/products/editPanier";
	}
	@PostMapping("edit-panier")
	public String editTasks(Model model , Panier panier) {
		panierService.update(panier);
		return "redirect:/panierTable";
	}
	
	
/*	@PostMapping("redirect")
	public String redirect(Model model , Commande c) {
		model.addAttribute("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", commandeService.findAll());
		
		return "views/products/commande";
	}*/
	
}
