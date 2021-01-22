package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Commande;
import com.example.Gestion.des.taches.project.repository.CommandeRepository;
import com.example.Gestion.des.taches.project.service.CommandeService;
@Service
public class CommandeServiceImlp implements CommandeService {
	@Autowired
	CommandeRepository repository ;
	
	@Override
	public Optional<Commande> findOne(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Commande> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	

	@Override
	public void save(Commande Commande) {
		// TODO Auto-generated method stub
		repository.save(Commande);
	}

	
}
