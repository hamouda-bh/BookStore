package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.Gestion.des.taches.project.model.Livre;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre,Long>{
	
	   @Query(value = "Select * from book b where " +
	            "(b.title like %?1% OR CAST(b.id as CHAR) like %?1% OR LOWER(b.author) like %?1%) " +
	            "AND b.category=?2",
	            nativeQuery = true)
	   List<Livre> findAllBookByCategoryAndKeyword(String keyword, String categorie);

	    @Query(value = "Select IF(SUM(b.sold) IS NULL,0,SUM(b.sold)) from book b where " +
	            "(b.title like %?1% OR CAST(b.id as CHAR) like %?1% OR LOWER(b.author) like %?1%) " +
	            "AND b.category=?2 AND b.sold>0",
	            nativeQuery = true)
	    long countNumberOfBooksSold(String keyword, String categorie);

	}
	

