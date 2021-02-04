package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Blog;


public interface BlogService {
	
Optional<Blog> findOne(int id_blog);
	
	List<Blog> findAll();
	
	void update(Blog blog);
	
	void save (Blog blog);
	
	void delete(int id_blog);
	
	void delete(Blog blog);

}
