package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Facture;

public interface FactureService {

	Optional<Facture> findOne(int id);
	
	List<Facture> findAll();
	
	//void update(Facture f);
	
	void save (Facture f);
	
	//void delete(int id);
	
	//void delete(Facture f);
}
