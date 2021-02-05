package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;

public interface PanierService {
	
	Optional<Panier> findOne(Long id);
	
	Iterable<Panier> findAll();
	
	void update(Panier panier);
	
	void save (Panier panier);
	
	void delete(Long id);
	
	public void addLivre(Livre l);
	
	List<Long> selectlesprice( long id);
	
	List<Long> selectlesqte( long id);
	
	void delete(Panier panier);
	
	void deleteall( long id);

}