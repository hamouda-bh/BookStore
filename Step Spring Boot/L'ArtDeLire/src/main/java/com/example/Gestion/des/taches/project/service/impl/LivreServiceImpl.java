package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.repository.LivreRepository;
import com.example.Gestion.des.taches.project.service.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;

import com.example.Gestion.des.taches.project.repository.LivreRepository;

import com.example.Gestion.des.taches.project.service.LivreService;

import exceptions.BadRequestException;
import exceptions.BookNotFoundException;
import exceptions.DuplicateResourceException;



@Service
public class LivreServiceImpl implements LivreService {
	  private static final Logger LOGGER = LoggerFactory.getLogger(LivreServiceImpl.class);
	   
	@Autowired
	LivreRepository repository ;
	
	/*@Override
	public Optional<Livre> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}*/

	@Override
	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	 @Override
	    public long ajouterLivre(Livre livre) {
	        return repository.save(livre).getId();
	    }
	@Override
	public void update(Livre livre) {
		// TODO Auto-generated method stub
		repository.save(livre);
	}

	@Override
	public void save(Livre livre) {
		// TODO Auto-generated method stub
		repository.save(livre);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void delete(Livre livre) {
		// TODO Auto-generated method stub
		repository.delete(livre);
	}

	
	
	public void addBook(Long id, int quantityToAdd) {
		//Get the book by id
        Livre livre = repository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with id:" + id + " is not registered. Use addNewBook to register."));
        LOGGER.info("The book with id " + id + " is registered");

        int totalCountAfterAdd = livre.getTotalCount() + quantityToAdd;
        livre.setTotalCount(totalCountAfterAdd);

        repository.save(livre);
    }

	
	@Override
	public int getNumberOfBooksById(Long id) {
		  Optional<Livre> livre = repository.findById(id);

	        //If book is present get Total Count else return 0
	        return livre.isPresent() ? livre.get().getTotalCount() : 0;
	    }

	 public void addNewBook(Livre livre) {
	        //Check if book is previously present
	        Optional<Livre> bookById = repository.findById(livre.getId());
	        bookById.ifPresent(book -> {
	            throw new DuplicateResourceException("Book with same id present. " +
	                    "Either use update methods to update the book counts or use addBook(Long id, int quantityToAdd) methods");
	        });
	        if (!bookById.isPresent()) {
	            LOGGER.info("No Duplicates found.");
	            //Map bookDto to book
	            //Book book = modelMapper.map(bookDto, Book.class);
	            //Set the status to available
	           // LOGGER.info("The data are mapped and ready to save.");

	            //Save to book
	            repository.save(livre); }
	        }

	
	
	/*public List<Livre> getBookByCategoryKeyWord(String keyword, Categorie categorie) {
		
//if the status is Available, gives list of books which are available
LOGGER.info("Fetch all the books by category and keyword.");
List<Livre> livre = repository.findAllBookByCategoryAndKeyword(keyword.toLowerCase(), Categorie.getName());
return livre;
}*/
	

	
	/*@Override
	public Optional<Livre> findOne(Long id) {
		return repository.findById(id);
		}*/
	public Livre findOne(Long id){
		return repository.findById(id).get();
	}
	
	@Override
	public List<Livre> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void updatePrice( Livre livre) {
		repository.save(livre);
	}
	@Override
	public Livre getBookById(Long id) {
		 Livre livre = repository.findById(id)
	                .orElseThrow(() -> new BookNotFoundException("Book with id:" + id + " is not found."));

	        return livre ;
	    }
	
	@Override
	public List<Livre> getBookByCategoryKeyWord(String keyword, Long id) {
		LOGGER.info("Fetch all the books by category and keyword.");
		List<Livre> livre = repository.findAllBookByCategoryAndKeyword(keyword.toLowerCase(),id);
		return livre;
		
	} 
	@Override
    public List<Livre> findByCategorie(Long id) {
        return  repository.findByCategorie(id);

    }
	@Override
	public Long countLivre() {
		return repository.countLivre();
	}
	
@Override
public List<Livre> findByName(String name) {
	return repository.findByName(name);
}

	
	
    }

