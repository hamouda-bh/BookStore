package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.LivreKids;

import com.example.Gestion.des.taches.project.repository.LivreKidsRepository;

import com.example.Gestion.des.taches.project.service.LivreKidsService;


@Service
public class LivreKidsServiceImpl implements LivreKidsService {
	
	LivreKidsRepository repository;
	@Override
	public Optional<LivreKids> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<LivreKids> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(LivreKids livreKids) {
		// TODO Auto-generated method stub
		repository.save(livreKids);
	}

	@Override
	public void save(LivreKids livreKids) {
		// TODO Auto-generated method stub
		repository.save(livreKids);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(LivreKids livreKids) {
		// TODO Auto-generated method stub
		repository.delete(livreKids);
	}

}