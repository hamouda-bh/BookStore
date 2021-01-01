package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Panier;

public interface PanierService {
	
	Optional<Panier> findOne(int id);
	
	List<Panier> findAll();
	
	void update(Panier panier);
	
	void save (Panier panier);
	
	void delete(int id);
	
	//void delete(Panier panier);

}
