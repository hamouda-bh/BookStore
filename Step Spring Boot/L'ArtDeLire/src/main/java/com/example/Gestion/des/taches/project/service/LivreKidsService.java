package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.LivreKids;


public interface LivreKidsService {
	
    Optional<LivreKids> findOne(Long id);
	
	List<LivreKids> findAll();
	
	void update(LivreKids livre);
	
	void save (LivreKids livre);
	
	void delete(Long id);
	
	void delete(LivreKids livre);

}
