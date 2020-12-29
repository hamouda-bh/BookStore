package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.UserTask;
import com.example.Gestion.des.taches.project.repository.StateRepository;
import com.example.Gestion.des.taches.project.repository.UserTaskRepository;
import com.example.Gestion.des.taches.project.service.UserTaskService;

@Service
public class UserTaskServiceImpl implements UserTaskService {
	@Autowired
	UserTaskRepository repository ;
	
	@Override
	public Optional<UserTask> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<UserTask> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(UserTask userTask) {
		// TODO Auto-generated method stub
		repository.save(userTask);
	}

	@Override
	public void save(UserTask userTask) {
		// TODO Auto-generated method stub
		repository.save(userTask);
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void delete(UserTask userTask) {
		// TODO Auto-generated method stub
		repository.delete(userTask);
	}

}
