package com.example.Gestion.des.taches.project.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.controller.UserController;
import com.example.Gestion.des.taches.project.model.Categorie;
import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.model.User;
import com.example.Gestion.des.taches.project.repository.LivreRepository;
import com.example.Gestion.des.taches.project.repository.PanierRepository;
import com.example.Gestion.des.taches.project.repository.StateRepository;
import com.example.Gestion.des.taches.project.repository.UserRepository;
import com.example.Gestion.des.taches.project.service.NotificationService;
import com.example.Gestion.des.taches.project.service.PanierService;
import com.example.Gestion.des.taches.project.service.UserService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository repository ;
	
	@Autowired
    private PanierRepository cartItemRepository;
    @Autowired
    PanierService cartitemservice;
    
    @Autowired
    private LivreRepository br;
    
    @Autowired
    private NotificationService sm ;
    
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
	
	
	@Override
	public Optional<User> findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		repository.save(user);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		repository.delete(user);
	}

	@Override
	public User findByEmail(String email) {
		 return repository.findByEmail(email) ;
	}

	@Override
	public Long countUser() {
		// TODO Auto-generated method stub
		return repository.countUser();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	@Override
	public String algoBook(long userId){		
	User u = repository.findById(userId).get();
	u.getId().toString();
		List<Panier> algo = u.getPanier();
		algo.toString();
		List<Livre> books = algo.stream().map(Panier::getLivre).collect(Collectors.toList());
		Map<String,Long> result =books.stream()
			.collect(Collectors.groupingBy(Livre::getAuthor,Collectors.counting()));
		Map<String, Long> finalMap = new LinkedHashMap<>();
		result.entrySet().stream()
		.sorted(Map.Entry.<String, Long>comparingByValue()
             .reversed()).forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		String toAuthor = finalMap.entrySet().iterator().next().getKey();
		String suggBook=br.findBookBySuggAuthor(toAuthor).getName();
		
		try {
		sm.sendEmail(u ,"Hello we saw that you are interested in " +toAuthor+
				" books  so we thought you might like this book aswell "+suggBook);
		}catch(MailException e){
			logger.info("Error Sending Email: " +e.getMessage());
		}
		
		return	suggBook;

}
	
	
	

}
