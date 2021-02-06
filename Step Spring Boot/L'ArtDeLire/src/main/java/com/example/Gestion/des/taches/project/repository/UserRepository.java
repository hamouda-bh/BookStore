package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email );
	
	@Query("select count(*) from User ")
	public Long countUser();
	
	
	
	
	

}
