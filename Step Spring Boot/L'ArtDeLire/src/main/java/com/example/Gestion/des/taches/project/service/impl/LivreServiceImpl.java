package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Livre;

import com.example.Gestion.des.taches.project.repository.LivreRepository;

import com.example.Gestion.des.taches.project.service.LivreService;


@Service
public class LivreServiceImpl implements LivreService {
	@Autowired
	LivreRepository repository ;
	
	
	
	@Override
	public Optional<Livre> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(Livre livre) {
		// TODO Auto-generated method stub
		repository.save(livre);
	}

	@Override
	public void save(Livre livre) {
		// TODO Auto-generated method stub
		repository.save(livre);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Livre livre) {
		// TODO Auto-generated method stub
		repository.delete(livre);
	}

}