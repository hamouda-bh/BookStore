package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.State;
import com.example.Gestion.des.taches.project.repository.StateRepository;
import com.example.Gestion.des.taches.project.service.StateService;


@Service
public class StateServiceImpl implements StateService {
	@Autowired
	StateRepository repository ;

	@Override
	public Optional<State> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<State> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(State state) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save(State state) {
		// TODO Auto-generated method stub
		repository.save(state);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void delete(State state) {
		// TODO Auto-generated method stub
		repository.delete(state);
	}
	

}
