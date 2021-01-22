package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Categorie;


public interface CategorieService {
	
Optional<Categorie> findOne(Long id);
	
	List<Categorie> findAll();
	
	void update(Categorie categorie);
	
	void save (Categorie categorie);
	
	void delete(Long id);
	
	void delete(Categorie categorie);

}
