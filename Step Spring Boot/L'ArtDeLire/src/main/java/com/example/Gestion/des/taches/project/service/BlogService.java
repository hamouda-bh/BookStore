package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Blog;


public interface BlogService {
	
   //Optional<Livre> findOne(Long id);
	
    Blog findOne(int id_blog);
  
	List<Blog> findAll() ;
	
	void update(Long idBlog );
	
	void addBlog(int id_blog);
	
	 int getNumberOfBlogsById(Long id);
	 
		public long ajouterBlog(Blog blog);

		void save(Blog blog);

		//void delete(int id_blog);

		void delete(Blog blog);
		Long countBlog();

		void delete(int id_blog);

		Blog findOne(Long id);

		void update(Blog blog);

	  
	  
	  
	  
	
	 
}