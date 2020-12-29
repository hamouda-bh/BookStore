package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.State;
import com.example.Gestion.des.taches.project.model.Task;

public interface TaskService {
	
    Optional<Task> findOne(Long id);
	
    List<Task> findAll();
	
	void update(Task state);
	
	void save (Task state);
	
	void delete(Long id);
	
	void delete(Task task);


}
