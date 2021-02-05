package com.example.Gestion.des.taches.project.service;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;


public interface LivreService {
	
   //Optional<Livre> findOne(Long id);
	
    Livre findOne(Long id);
  
	List<Livre> findAll() ;
	
	void update(Livre livre );
	
	void addBook(Long id, int quantityToAdd);
	
	 int getNumberOfBooksById(Long id);
	 
	  void addNewBook(Livre livre);
	  
	  //Livre getBookById(Long id);
	  
	  List<Livre> findByName(String name); 
	  
	  
	  
	  List<Livre> getAllBooks();

	  void updatePrice(Livre livre);

	 void save (Livre livre);
	
	 void delete(Long id);
	
	 void delete(Livre livre);
	
	public long ajouterLivre(Livre livre);
	
	 List<Livre> getBookByCategoryKeyWord(String keyword, Long id);
	 
	 List<Livre> findByCategorie(Long id );

	 

	Livre getBookById(Long id);
	
	 Long countLivre();
}