package com.example.Gestion.des.taches.project.controller;

import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.CommandeService;
import com.example.Gestion.des.taches.project.service.LivreService;
import com.example.Gestion.des.taches.project.service.PanierService;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PanierController {
	//private static final Logger l = Logger.getLogger(PanierController.class);

	@Autowired
	private PanierService panierService;
	
	@GetMapping(value = "findOneP/{idemp}")
	   public Optional<Panier> findOne(@PathVariable("idemp")long id) {
			return panierService.findOne(id);
		}
	@GetMapping(value = "findAllP")
	public Iterable<Panier> findAll() {
		return panierService.findAll();
	}
	@PostMapping("/addLivreP/{id_livre}")
	public String ajouterLivre(@RequestBody Livre l) {
		panierService.addLivre(l);
		return l.getName();
	}
	@PostMapping("/saveP")
	public long saveP(@RequestBody Panier p) {
		panierService.save(p);
		return p.getId_panier();
	}
	@DeleteMapping("/deleteP/{idemp}") 
	public void delete(@PathVariable("idemp")long id) {

		//try {
			panierService.delete(id);
			//l.info("article deleted ");}
			//catch (Exception e) { l.error("Erreur de suppression" + e); }
	}
	@PutMapping(value = "/updateP/{id}/{quantite}") 
 	@ResponseBody
	public void update(@PathVariable("newemail") int quantite, @PathVariable("id") long id_panier) {
		Optional<Panier> l =panierService.findOne(id_panier);
		Panier p =l.get();		
		p.setQuantite_ajouter(quantite);
		panierService.update(p);
	}
	
/*	@GetMapping("/panierTable")
	public String listTasks(Model model) {
		model.addAttribute("paniers", panierService.findAll());
		return "views/products/panierTable";
	}
	
	@GetMapping("/add-panier")
	public String addTasks(Model model) {
		model.addAttribute("paniers", new Panier());
		return "views/products/panierTable";
	}
	
	
	
	@PostMapping("/add-panier")
	public String addTasks(Model model , Panier panier) {
		panierService.save(panier);
		return "redirect:/panierTable";
	}
	
	@GetMapping("/delete-panier")
	public String deleteTask(@RequestParam("id_panier") Long id) {
	
		//try {
			panierService.delete(id);
			//l.info("article deleted ");}
			//catch (Exception e) { l.error("Erreur de suppression" + e); }
	
		return "redirect:/panierTable";
	}

	@GetMapping("/edit-panier")
	public String editTask(@RequestParam("id_panier") Long id, Model model, Panier panier) {
	//	model.addAttribute("livres", livreService.findOne(id).get());
		model.addAttribute("paniers", panierService.findOne(id).get());
		return "views/products/editPanier";
	}
	
	@PostMapping("/edit-panier")
	public String editTasks(Model model , Panier panier) {
		panierService.update(panier);
		return "redirect:/panierTable";
	}
	
@GetMapping("/redirect")
	public String redirect() {

		return "views/products/commande";
	}*/
	
}
