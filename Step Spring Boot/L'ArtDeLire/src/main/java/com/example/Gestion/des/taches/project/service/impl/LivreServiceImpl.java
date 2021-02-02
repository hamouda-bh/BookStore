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

	
	@Autowired
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

	@Override
	
		public void sellBook(Long id) {
	        Livre livre = repository.findById(id)
	                .orElseThrow(() -> new BookNotFoundException("Book with id: " + id + " is not found."));
	        //Selling one book decreases the amount of book in the store and increases the amount of book sold.
	        int totalCount = livre.getTotalCount() - 1;
	        if (totalCount < 0) {
	            throw new BadRequestException("TotalCount cannot be negative. Not enough book in store to sell.");
	        }
	        int sold = livre.getSold() + 1;
	        LOGGER.info("Setting total amount less by 1 and setting sold to increase by 1.");
	        livre.setTotalCount(totalCount);
	        livre.setSold(sold);
	        repository.save(livre);
	    }

		
	
	@Override
	public List<Livre> getBookByCategoryKeyWord(String keyword, Categorie categorie) {
		
//if the status is Available, gives list of books which are available
LOGGER.info("Fetch all the books by category and keyword.");
List<Livre> livre = repository.findAllBookByCategoryAndKeyword(keyword.toLowerCase(), categorie.getName());
return  livre;
}
	

	@Override
	 public int getNumberOfBooksSoldByCategoryAndKeyword(String keyword,
             Categorie categorie) {
LOGGER.info("Total number of books which are sold");
return (int) repository.countNumberOfBooksSold(keyword.toLowerCase(), categorie.getName());
}
	@Override
	public Optional<Livre> findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}