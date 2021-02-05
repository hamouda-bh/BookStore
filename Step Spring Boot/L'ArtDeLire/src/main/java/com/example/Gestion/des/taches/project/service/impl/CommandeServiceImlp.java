package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.repository.CommandeRepository;
import com.example.Gestion.des.taches.project.service.CommandeService;
@Service
public class CommandeServiceImlp implements CommandeService {
	
	@Autowired
	CommandeRepository repository ;
	
	@Override
	public Optional<Commande> findOne(int id) {
		return repository.findById(id);
	}

	@Override
	public List<Commande> findAll() {
		return repository.findAll();
	}

	@Override
	public int selectnbcom(Commande l) {
		return repository.selectnbcommande(l.getUser().getId());
	}
	
	@Override
	public void save(Commande Commande) {
		repository.save(Commande);
	}
	@Override
	public void insertcommande(String date, float somme, long id)
	{
		
		repository.insertcommande(date,somme, id);
		
	}
}
