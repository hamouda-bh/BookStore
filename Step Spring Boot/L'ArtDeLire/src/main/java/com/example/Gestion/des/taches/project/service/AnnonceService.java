package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Annonce;

public interface AnnonceService {
	
	Optional<Annonce> findOne(Long id);
	
	List<Annonce> findAll();
	
	void update(Annonce annonce);
	
	void save (Annonce annonce);
	
	void delete(Long id);
	
	void delete(Annonce annonce);
	
     
}
