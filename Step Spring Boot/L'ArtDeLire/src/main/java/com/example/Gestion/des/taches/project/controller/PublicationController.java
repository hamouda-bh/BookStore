package com.example.Gestion.des.taches.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.LivreService;


@RestController
public class LivreController {
	
	@Autowired
	private PublicationService publicationService ;
	
	//@GetMapping("list-publications")
	//public String listPublication(Publication publication) {
	//publicationService("Publication", publicationService.findAll());
			
	//}
	@PostMapping("/savePublication")
	public Publication save(@RequestBody Publication publication) {
		publicationService.save(publication);
		return publication ;
	}
	
	@PostMapping("/ajouterPublication")
	public Publication ajouterLivre(@RequestBody  Publication publication) {
		publicationService.ajouterPublication(publication);
		return publication ;
	}
	@GetMapping("/supprimerPublication")
	public void delete(@PathVariable("id_publication") int id) {
		publicationService.delete(id);
	}
		 
		 
    @GetMapping(value = "findOneL/{id_publication}")
		   public Optional<Publication> findOne(@PathVariable int id) {
				return publicationService.findOne(id);
			}
    
    @GetMapping(value = "findAllL")
	public Iterable<Publication> findAll() {
		return publicationService.findAll();
	}
		
	
	//@GetMapping("edit-Publication")
	//public String editPublication(@RequestParam("id_publication") int id, Publication publication) {
		//model.addAttribute("Publication", publicationService.findOne(id).get());

		//return "views/products/add-publication";
	//}
	
	//@PutMapping(value = "/updatePublication/{id}/") 
 	//@ResponseBody
	//public void update(@PathVariable("newPublication") int id, @PathVariable("id") Long idPublication) {
	//publicationService.update(id_publication);}
	}