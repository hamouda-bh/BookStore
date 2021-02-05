package com.example.Gestion.des.taches.project.controller;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.service.CommandeService;
import com.example.Gestion.des.taches.project.service.PanierService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private PanierService panierService;

	@GetMapping(value = "findOneC/{idemp}")
	   public Optional<Commande> findOne(@PathVariable("idemp")int id) {
			return commandeService.findOne(id);
		}
	@GetMapping(value = "findAllC")
	public Iterable<Commande> findAll() {
		return commandeService.findAll();
	}
	
	@PostMapping("/saveC")
	public long saveP(@RequestBody Commande c) {
		commandeService.save(c);
		return c.getId_commande();
	}
	
	@PostMapping("/insertC")
	public void insertcommande(@RequestBody long id)
	{
		float f=0 ;
		int i;
		List<Long> l1 =panierService.selectlesprice(id);
		List<Long> l2 =panierService.selectlesqte(id);
		for (i=0; i< l1.size();i++)
		{
		f= 	(float) f+ (l1.get(i) *l2.get(i));
		}
		commandeService.insertcommande(java.util.Calendar.getInstance().getTime().toString(),f, id);
	}	
	
	@GetMapping(path ="/selectnb/{id_user}")
	public int selectnbcom(@PathVariable("id_user")long id ) {
		List<Commande> list = commandeService.findAll();
		for (int i=0;i<list.size();i++)
		{
			Commande p =list.get(i);
			User u = p.getUser();
				long idUser = u.getId();
				if (idUser== id)
				   return commandeService.selectnbcom(p);
		}
			return 0;
	}
	
	
	/*
	@GetMapping("/addCommande")
	public String addTasks(Model model) {
		model.addAttribute("commandes", new Commande());
		return "views/products/commande";
	}
	
	@PostMapping("/addCommande")
	public String addTasks(Model model , Commande c) {
		commandeService.save(c);
		return "redirect:/commande";
	}
	
	/*@GetMapping("delete-panier")
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
	
	@GetMapping("/redirectR")
	public String redirect() {

		return "views/products/panierTable";
	}
	@GetMapping("/redirectC")
	public String redirectC() {
		return "views/products/terminer";
	}
	*/
}
