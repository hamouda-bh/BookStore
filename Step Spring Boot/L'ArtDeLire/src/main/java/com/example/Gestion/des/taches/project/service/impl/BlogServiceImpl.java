package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Blog;
import com.example.Gestion.des.taches.project.repository.BlogRepository;
import com.example.Gestion.des.taches.project.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Blog;

import com.example.Gestion.des.taches.project.repository.BlogRepository;

import com.example.Gestion.des.taches.project.service.BlogService;
/*
import exceptions.BadRequestException;
import exceptions.BookNotFoundException;
import exceptions.DuplicateResourceException;
*/


@Service
public class BlogServiceImpl implements BlogService {
	  private static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);
	   
	@Autowired
	BlogRepository repository ;
	
	/*@Override
	public Optional<Blog> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}*/

	@Override
	public List<Blog> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	 @Override
	    public long ajouterBlog(Blog blog) {
	        return repository.save(blog).getId_blog();
		   
	 }
	@Override
	public void update(Blog blog) {
		// TODO Auto-generated method stub
		repository.save(blog);
	}

	@Override
	public void save(Blog blog) {
		// TODO Auto-generated method stub
		repository.save(blog);
	}

	

	@Override
	public void delete(Blog blog) {
		// TODO Auto-generated method stub
		repository.delete(blog);
	}

	
	/*
	public void addBlog(int id_blog, int quantityToAdd) {
		//Get the book by id
        Blog blog = repository.findById(id_blog)
                .orElseThrow(() -> new BlogNotFoundException("Blog with id:" + id_blog + " is not registered. Use addNewBlog to register."));
        LOGGER.info("The blog with id " + id_blog + " is registered");

        int totalCountAfterAdd = blog.getTotalCount() + quantityToAdd;
        blog.setTotalCount(totalCountAfterAdd);

        repository.save(blog);
    }*/

	
	public Blog findOne(int id_blog){
		return repository.findById((long) id_blog).get();
	}
	
	
	@Override
	public Long countBlog() {
		return repository.countBlog();
	}
	/*
	@Override
	public Optional<Blog> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);	
		
}*/
	
	@Override
	public void addBlog(int id_blog) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getNumberOfBlogsById(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void delete(int id_blog) {
		repository.deleteById((long) id_blog);		}
	@Override
	public Blog findOne(Long id) {
		return repository.findById(id).get();
	}
	@Override
	public void update(Long idBlog) {
		// TODO Auto-generated method stub
		
	}


	
	
    }