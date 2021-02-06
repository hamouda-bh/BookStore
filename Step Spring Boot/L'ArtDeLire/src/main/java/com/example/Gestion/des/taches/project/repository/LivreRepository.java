package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long>{
	
	@Query("select count(id) from Livre ")
	public Long countLivre();
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM livre TB   WHERE TB.author=:author ORDER BY RAND() LIMIT 1 ")
    Livre findBookBySuggAuthor(
    		  @Param("author") String author);
	
	

}
