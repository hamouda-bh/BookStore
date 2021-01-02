package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.repository.StateRepository;
import com.example.Gestion.des.taches.project.repository.UserRepository;
import com.example.Gestion.des.taches.project.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository ;
	
	
	@Override
	public Optional<User> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		repository.delete(user);
	}

	@Override
	public User findByEmail(String email) {
		 return repository.findByEmail(email) ;
	}

}
