package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Livre;

public interface LivreService {
	
    Optional<Livre> findOne(Long id);
	
	List<Livre> findAll();
	
	void update(Livre livre);
	
	void save (Livre livre);
	
	void delete(Long id);
	
	void delete(Livre livre);
	
}
