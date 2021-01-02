package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.CategorieKids;

public interface CategorieKidsService {
Optional<CategorieKids> findOne(Long id);
	
	List<CategorieKids> findAll();
	
	void update(CategorieKids CategorieKids);
	
	void save (CategorieKids CategorieKids);
	
	void delete(Long CategorieKids);
	
	void delete(CategorieKids CategorieKids);
}
