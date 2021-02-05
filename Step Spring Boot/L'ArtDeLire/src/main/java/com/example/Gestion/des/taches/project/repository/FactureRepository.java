package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.Gestion.des.taches.project.model.Facture;

public interface FactureRepository extends JpaRepository<Facture, Integer> {
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO facture (date_commande, support_pdf,commande_id_commande) VALUES (:lowel, :theni, :theleth);", nativeQuery = true)
	void insertcommande(@Param("lowel") String date, @Param("theni") String pdf, @Param("theleth")  long id);
	
}
