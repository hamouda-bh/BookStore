package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Annonce;
import com.example.Gestion.des.taches.project.repository.AnnonceRepository;
import com.example.Gestion.des.taches.project.service.AnnonceService;

@Service
public class AnnonceServiceImpl implements AnnonceService {
	
	@Autowired
	AnnonceRepository repository;
	
	@Override
	public Optional<Annonce> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Annonce> findAll() {
		return repository.findAll();
	}

	@Override
	public void update(Annonce annonce) {
		repository.save(annonce);
	}

	@Override
	public void save(Annonce annonce) {
		repository.save(annonce);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Annonce annonce) {
		repository.delete(annonce);
	}

}
