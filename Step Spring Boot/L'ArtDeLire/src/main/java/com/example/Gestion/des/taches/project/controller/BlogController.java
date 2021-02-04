package com.example.Gestion.des.taches.project.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.service.CategorieService;
import com.example.Gestion.des.taches.project.service.LivreService;


@RestController
public class BlogController {
	
	@Autowired
	private BlogService blogService ;
	
	//@GetMapping("list-blogs")
	//public String listBlog(Blog blog) {
	//publicationService("Blog", blogService.findAll());
			
	//}
	@PostMapping("/saveBlog")
	public Blog save(@RequestBody Blog blog) {
		blogService.save(blog);
		return blog ;
	}
	
	@PostMapping("/ajouterBlog")
	public Blog ajouterBlog (@RequestBody  Blog blog) {
		blogService.ajouterBlog(blog);
		return blog ;
	}
	@GetMapping("/supprimerBlog")
	public void delete(@PathVariable("id_blog") int id) {
		blogService.delete(id);
	}
		 
		 
    @GetMapping(value = "findOneL/{id_blog}")
		   public Optional<Blog> findOne(@PathVariable int id) {
				return blogService.findOne(id);
			}
    
    @GetMapping(value = "findAllL")
	public Iterable<Blog> findAll() {
		return blogService.findAll();
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