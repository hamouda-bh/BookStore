package com.example.Gestion.des.taches.project.service.impl;

import java.util.*;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Categorie;

import com.example.Gestion.des.taches.project.repository.CategorieRepository;

import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.TaskService;

@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	CategorieRepository repository ;
	
	
	
	@Override
	public Optional<Categorie> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(Categorie categorie) {
		// TODO Auto-generated method stub
		repository.save(categorie);
	}

	@Override
	public void save(Categorie categorie) {
		// TODO Auto-generated method stub
		repository.save(categorie);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Categorie categorie) {
		// TODO Auto-generated method stub
		repository.delete(categorie);
	}

	@Override
	public Long countCategorie() {
		// TODO Auto-generated method stub
		return repository.countCategorie();
	}

}
