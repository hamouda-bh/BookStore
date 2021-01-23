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
	private LivreService livreService ;
	@Autowired
	private CategorieService categorieService;
	
	//@GetMapping("list-livres")
	//public String listLivre(Livre livre) {
	//livreService("livres", livreService.findAll());
			
	//}
	@PostMapping("/savelivre")
	public Livre save(@RequestBody Livre livre) {
		livreService.save(livre);
		return livre ;
	}
	
	@PostMapping("/ajouterlivre")
	public Livre ajouterLivre(@RequestBody  Livre livre) {
		livreService.ajouterLivre(livre);
		return livre ;
	}
	@GetMapping("/supprimerlivre")
	public void delete(@PathVariable("idLivre") Long id) {
		 livreService.delete(id);
	}
		 
		 
    @GetMapping(value = "findOneL/{idLivre}")
		   public Optional<Livre> findOne(@PathVariable Long id) {
				return livreService.findOne(id);
			}
    
    @GetMapping(value = "findAllL")
	public Iterable<Livre> findAll() {
		return livreService.findAll();
	}
		
	
	//@GetMapping("edit-livre")
	//public String editLivre(@RequestParam("idLivre") Long id, Livre livre) {
		//model.addAttribute("livres", livreService.findOne(id).get());
		//model.addAttribute("categories", categorieService.findAll());

		//return "views/products/add-livre";
	//}
	
	//@PutMapping(value = "/updateL/{id}/") 
 	//@ResponseBody
	//public void update(@PathVariable("newlivre") Long id, @PathVariable("id") Long idLivre) {
	//livreService.update(idLivre);}
	}
	
