package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Gestion.des.taches.project.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
	
	@Query("select count(id) from Categorie ")
	public Long countCategorie();

}
