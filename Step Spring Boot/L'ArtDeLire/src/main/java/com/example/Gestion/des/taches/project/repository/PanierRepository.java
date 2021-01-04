package com.example.Gestion.des.taches.project.repository;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.Gestion.des.taches.project.model.Panier;

public interface PanierRepository extends CrudRepository<Panier, Long> {
	

	@Modifying
	@Query(value = "INSERT INTO panier (id_panier,quantite_ajouter, somme_ajoute, livre_id) VALUES (:kbal,:lowel, :theni, :aa);", nativeQuery = true)
	void insertUser(@Param("kbal") Long idpanier,@Param("lowel") int quantite, @Param("theni") float somme, @Param("aa")  Long idlivre);

}
