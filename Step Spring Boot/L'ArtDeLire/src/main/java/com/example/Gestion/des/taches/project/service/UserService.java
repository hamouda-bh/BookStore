package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.State;
import com.example.Gestion.des.taches.project.model.User;

public interface UserService {
	
    Optional<User> findOne(Long id);
	
	List<User> findAll();
	
	void update(User user);
	
	void save (User user);
	
	void delete(Long id);
	
	void delete(User user);

    User findByEmail(String email  );
}
