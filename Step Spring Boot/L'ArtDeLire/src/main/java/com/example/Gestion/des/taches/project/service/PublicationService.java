package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Publication;


public interface PublicationService {
	
Optional<Publication> findOne(int id_publication);
	
	List<Publication> findAll();
	
	void update(Publication publication);
	
	void save (Publication publication);
	
	void delete(int id_publication);
	
	void delete(Publication publication);

	long ajouterPublication(Publication publication);

}
