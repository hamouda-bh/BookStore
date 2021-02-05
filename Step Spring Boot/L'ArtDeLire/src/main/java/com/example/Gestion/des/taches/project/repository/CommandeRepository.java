package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.Gestion.des.taches.project.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
	
	@Modifying
    @Transactional
	@Query(value = "INSERT INTO commande (date_commande, prix_totale, user_id) VALUES (:lowel, :theni, :aa);", nativeQuery = true)
	void insertcommande(@Param("lowel") String date, @Param("theni") float prix, @Param("aa")  long id);
	
    @Transactional
	@Query(value = "SELECT count(*) FROM commande c where c.user_id= :lowel ; ", nativeQuery = true)
	int selectnbcommande( @Param("lowel")  long id);
	
}
