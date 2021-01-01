package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Commande;

public interface CommandeService {


	Optional<Commande> findOne(int id);
	
	List<Commande> findAll();
	
	//void update(Commande commande);
	
	void save (Commande commande);
	
	void delete(int id);
	
	//void delete(Commande commande);

	
}
