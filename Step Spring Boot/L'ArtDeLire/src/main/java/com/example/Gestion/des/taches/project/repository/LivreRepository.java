package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre,Long>{
	
	   @Query(value = "Select * from livre l where " +
	            "(l.name like %?1% OR CAST(l.id as CHAR) like %?1% OR LOWER(l.author) like %?1%) " +
	            "AND l.categorie_id=?2",
	            nativeQuery = true)
	   List<Livre> findAllBookByCategoryAndKeyword(String keyword, Long id);

	   

	     @Query("select count (*) from Livre ")
		 public Long countLivre();
	     
	     
	    	    @Query(value = "SELECT * FROM livre e WHERE e.categorie_id = ?1" , nativeQuery = true)
	    	    List<Livre> findByCategorie(Long id);

				
	    	   List<Livre> findByName(String name); 
	    	   

	    	}
	
	

