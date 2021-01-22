package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Role;
import com.example.Gestion.des.taches.project.repository.RoleRepository;
import com.example.Gestion.des.taches.project.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository repository ;
	

	@Override
	public Optional<Role> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(Role role) {
		// TODO Auto-generated method stub
		repository.save(role);
	}

	@Override
	public void save(Role role) {
		// TODO Auto-generated method stub
		repository.save(role);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
	}

	@Override
	public void delete(Role role) {
		// TODO Auto-generated method stub
		repository.delete(role);
	}

}
