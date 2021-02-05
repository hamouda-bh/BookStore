package com.example.Gestion.des.taches.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.Gestion.des.taches.project.model.Panier;
import java.util.List;

public interface PanierRepository extends JpaRepository<Panier, Long> {
	
    @Modifying
    @Transactional
	@Query(value = "INSERT INTO panier (quantite_ajouter, somme_ajoute, livre_id) VALUES (:lowel, :theni, :aa);", nativeQuery = true)
	void insertLivre(@Param("lowel") Integer quantite, @Param("theni") float somme, @Param("aa")  Long idlivre);


    
	@Query(value = "SELECT somme_ajoute FROM panier c where c.user_id= :lowel ; ", nativeQuery = true)
	List<Long> selectlesprix( @Param("lowel")  long id);
    
	@Modifying
	 @Transactional
	@Query(value = "DELETE FROM panier WHERE panier.user_id = :lowel ; ", nativeQuery = true)
	void delete( @Param("lowel")  long id);
	
    @Transactional
	@Query(value = "SELECT quantite_ajouter FROM panier c where c.user_id= :lowel ; ", nativeQuery = true)
    List<Long> selectlesqte( @Param("lowel")  long id);
}

