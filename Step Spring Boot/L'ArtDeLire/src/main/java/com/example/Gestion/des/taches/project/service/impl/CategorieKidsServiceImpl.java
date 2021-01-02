package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.CategorieKids;
import com.example.Gestion.des.taches.project.repository.CategorieKidsRepository;
import com.example.Gestion.des.taches.project.repository.CategorieRepository;
import com.example.Gestion.des.taches.project.service.CategorieKidsService;

public class CategorieKidsServiceImpl implements CategorieKidsService{
	@Autowired
	CategorieKidsRepository repository ;
	
	
	
	@Override
	public Optional<CategorieKids> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<CategorieKids> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(CategorieKids CategorieKids) {
		// TODO Auto-generated method stub
		repository.save(CategorieKids);
	}

	@Override
	public void save(CategorieKids CategorieKids) {
		// TODO Auto-generated method stub
		repository.save(CategorieKids);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(CategorieKids CategorieKids) {
		// TODO Auto-generated method stub
		repository.delete(CategorieKids);
	}
}
