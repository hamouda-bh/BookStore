package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Facture;
import com.example.Gestion.des.taches.project.repository.FactureRepository;
import com.example.Gestion.des.taches.project.service.FactureService;
@Service
public class FactureServiceImpl implements FactureService {
	
	@Autowired
	FactureRepository repository ;
	
	@Override
	public Optional<Facture> findOne(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Facture> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


	@Override
	public void save(Facture Facture) {
		// TODO Auto-generated method stub
		repository.save(Facture);
	}

}
