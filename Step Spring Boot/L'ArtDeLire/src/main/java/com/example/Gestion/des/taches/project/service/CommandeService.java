package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.model.Livre;

public interface CommandeService {


	Optional<Commande> findOne(int id);
	
	List<Commande> findAll();
	
	//void update(Commande commande);
	
	void save (Commande commande);
	
	void insertcommande(String date, float somme, long id);
	
	
	public int selectnbcom(Commande l);
	
	//void delete(int id);
	
	//void delete(Commande commande);

	
}
