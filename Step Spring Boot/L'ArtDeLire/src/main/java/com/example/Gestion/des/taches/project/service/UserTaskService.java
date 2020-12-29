package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.State;
import com.example.Gestion.des.taches.project.model.UserTask;

public interface UserTaskService {
	
     Optional<UserTask> findOne(Long id);
	
	List<UserTask> findAll();
	
	void update(UserTask userTask);
	
	void save (UserTask userTask);
	
	void delete(Long id);
	
	void delete(UserTask userTask);


}
