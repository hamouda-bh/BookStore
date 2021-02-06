
package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Gestion.des.taches.project.model.Blog;

import antlr.collections.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
	
	/* @Query(value = "Select * from blog b where " +
	            "(b.id_bloglike %?1%  " +
	            "AND b.author=?2",
	            nativeQuery = true)
	   List<Blog> findAllBookByauthorAndid_blog(String author, int id);

	   */

	     @Query("select count (*) from Blog ")
		 public Long countBlog();
	     
	    	   

	    	   
}
