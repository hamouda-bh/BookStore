package com.example.Gestion.des.taches.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.des.taches.project.model.Blog;
import com.example.Gestion.des.taches.project.service.BlogService;


@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogservice ;
	
	//@GetMapping("list-blogs")
	//public String listBlog(Blog blog) {
	//publicationService("Blog", blogService.findAll());
			
	//}
	@PostMapping("/saveBlog")
	public Blog save(@RequestBody Blog blog) {
		blogservice.save(blog);
		return blog ;
	}
	/*
	@GetMapping("/blog/{id}")
    @ResponseBody
    public Blog getBlogById(@PathVariable ("id") Long id) {
        return blogservice.getBlogById(id);
    }
    */
	@PostMapping("/ajouterBlog")
	public Blog ajouterBlog (@RequestBody  Blog blog) {
		blogservice.ajouterBlog(blog);
		return blog ;
	}
	
	
	
	
	
	
	
	@GetMapping("/supprimerBlog")
	public void delete(@PathVariable("id_blog") int id_blog) {
		blogservice.delete(id_blog);
	}
		 
	 
    @GetMapping(value = "findOne/{id_blog}")
		   public Blog findOne(@PathVariable int id_blog) {
				return blogservice.findOne(id_blog);
			}
    
    @GetMapping(value = "findAll")
	public Iterable<Blog> findAll() {
		return blogservice.findAll();
	}
    
    
    @GetMapping("/countBlog")
    public Long countBlog(){
    	return blogservice.countBlog();
    }
	
	//@GetMapping("edit-blog")
	//public String editblog(@RequestParam("id_blog") int id, Blog blog) {
		//model.addAttribute("Blog", blogService.findOne(id).get());

		//return "views/products/add-blog";
	//}
	
	//@PutMapping(value = "/updateBlog/{id}/") 
 	//@ResponseBody
	//public void update(@PathVariable("newBlog") int id, @PathVariable("id") Long idBlog) {
	//blogService.update(id_blog);}
	}