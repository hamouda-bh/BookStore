  
package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.Panier;

public interface PanierRepository extends JpaRepository<Panier, Long> {
	
    @Modifying
	@Query(value = "INSERT INTO panier (quantite_ajouter, somme_ajoute, livre_id) VALUES (:lowel, :theni, :aa);", nativeQuery = true)
	void insertLivre(@Param("lowel") int quantite, @Param("theni") float somme, @Param("aa")  Long idlivre);

}