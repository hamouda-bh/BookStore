package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Task;
import com.example.Gestion.des.taches.project.repository.RoleRepository;
import com.example.Gestion.des.taches.project.repository.TaskRepository;
import com.example.Gestion.des.taches.project.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskRepository repository ;
	
	
	
	@Override
	public Optional<Task> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Task> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(Task task) {
		// TODO Auto-generated method stub
		repository.save(task);
	}

	@Override
	public void save(Task task) {
		// TODO Auto-generated method stub
		repository.save(task);
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Task task) {
		// TODO Auto-generated method stub
		repository.delete(task);
	}

}
