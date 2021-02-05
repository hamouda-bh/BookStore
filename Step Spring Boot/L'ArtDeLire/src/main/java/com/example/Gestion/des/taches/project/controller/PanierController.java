package com.example.Gestion.des.taches.project.controller;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.service.LivreService;
import com.example.Gestion.des.taches.project.service.PanierService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PanierController {
//	private static final Logger l = Logger.getLogger(PanierController.class);
	
	@Autowired
	private PanierService panierService;

	@Autowired
	private LivreService livreS;
	//4 6 11 12
	@GetMapping(value = "findOneP/{idemp}")
	@ResponseBody
	   public Optional<Panier> findOne(@PathVariable("idemp") long id) {
			return panierService.findOne(id);
	}
	@GetMapping(value = "findAllP")
	@ResponseBody
	public Iterable<Panier> findAll() {
		return panierService.findAll();
	}
	
	//3 4 5 6 
	@PostMapping(path ="/addLivreP/{id_livre}")
	public String ajouterLivre(@PathVariable("id_livre")long id ) {
		Optional<Livre> l = livreS.findOne(id);
		if(l.isPresent()){	
			Livre p =l.get();	
			panierService.addLivre(p);
		return p.getName();
		}
		return null;
	}
	//2
	@GetMapping(value = "prix/{id_user}")
	@ResponseBody
	public List<Long> selectprix(@PathVariable("id_user") long id ) {
			return panierService.selectlesprice(id);
	}
	//2
	@GetMapping(value = "qte/{id_user}")
	@ResponseBody
	public  List<Long> selectqte(@PathVariable("id_user") long id ) {
			return panierService.selectlesqte(id);
					}
	//2
	@GetMapping(value = "prixFinal/{id_user}")
	@ResponseBody
	public  float selectprixFinal(@PathVariable("id_user") long id ) {
		float f=0 ;
		int i;
		for (i=0; i< panierService.selectlesprice(id).size();i++)
		{
		f= 	(float) f+ (panierService.selectlesprice(id).get(i) *panierService.selectlesqte(id).get(i));
		
		}
		return f;
	}
	
	
	@PostMapping("/saveP")
	@ResponseBody
	public long saveP(@RequestBody Panier p) {
		panierService.save(p);
		return p.getId_panier();
	}
	//4 6 11 12
	@DeleteMapping("/deleteP/{idemp}") 
	public void delete(@PathVariable("idemp")long id) {
		//try {
			panierService.delete(id);
			//l.info("article deleted ");}
			//catch (Exception e) { l.error("Erreur de suppression" + e); }
	}
	//2 3 
	@DeleteMapping("/deletePall/{idusr}") 
	public void deleteall(@PathVariable("idusr")long id) {
		//try {
			panierService.deleteall(id);
			//l.info("article deleted ");}
			//catch (Exception e) { l.error("Erreur de suppression" + e); }
	}
	
	// 4 6 '11' 12
	@PutMapping(value = "/updateP/{id}") 
	public void update(@RequestBody int quantite, @PathVariable("id") long id_panier) {
		Optional<Panier> l =panierService.findOne(id_panier);
		if(l.isPresent()){	
			Panier p =l.get();	
			p.setQuantite_ajouter(quantite);
			panierService.delete(id_panier);
		panierService.save(p);
		}	
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