package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Role;

public interface RoleService {
	
	Optional<Role> findOne(Long id);
	
	List<Role> findAll();
	
	void update(Role role);
	
	void save (Role role);
	
	void delete(Long id);
	
	void delete(Role role);
	
     
}
