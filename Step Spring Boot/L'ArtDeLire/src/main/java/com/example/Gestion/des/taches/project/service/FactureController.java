package com.example.Gestion.des.taches.project.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.Gestion.des.taches.project.model.Facture;
@RestController
public class FactureController {
	
		@Autowired
		private FactureService factureService ;
		
		@GetMapping(value = "findOneF/{idemp}")
		   public Optional<Facture> findOne(@PathVariable("idemp")int id) {
				return factureService.findOne(id);
			}
		@GetMapping(value = "findAllF")
		public Iterable<Facture> findAll() {
			return factureService.findAll();
		}
		
		@PostMapping("/saveF")
		public long saveP(@RequestBody Facture f) {
			factureService.save(f);
			return f.getIdFacture();
		}
		
}
