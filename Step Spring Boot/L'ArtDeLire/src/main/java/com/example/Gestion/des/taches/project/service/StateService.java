package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Role;
import com.example.Gestion.des.taches.project.model.State;

public interface StateService {
	Optional<State> findOne(Long id);
	
	List<State> findAll();
	
	void update(State state);
	
	void save (State state);
	
	void delete(Long id);
	
	void delete(State state);

}
