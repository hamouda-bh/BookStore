package com.example.Gestion.des.taches.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.example.Gestion.des.taches.project.model.Livre;
import com.example.Gestion.des.taches.project.model.Panier;
import com.example.Gestion.des.taches.project.repository.PanierRepository;
import com.example.Gestion.des.taches.project.service.PanierService;

@Service
public class PanierServiceImpl implements PanierService {
	//private static final Logger l = Logger.getLogger(PanierServiceImpl.class);

	@Autowired
	PanierRepository repository ;
	
	@Override
	public Optional<Panier> findOne(Long id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<Panier> findAll() {
		return  repository.findAll();
	}

	@Override
	public void update(Panier Panier) {
		repository.save(Panier);
		
	}

	@Override
	public void save(Panier Panier) {
		repository.save(Panier);
	}

	@Override
	public void delete(Long id) {
		
		//try {
		repository.deleteById(id);
		
		//l.info("article deleted ");}
	//	catch (Exception e) { l.error("Erreur de suppression" + e); }
		
	}
	
	@Override
	public void deleteall( long id)
	{
		repository.delete(id);
	}
	

	@Override
	public void delete(Panier panier) {
		repository.delete(panier);
	}
	
	@Override
	public void addLivre(Livre l) {
		repository.insertLivre(1, l.getPrix(), l.getId(),(long) 2);
	}
	@Override
	public List<Long> selectlesprice(long id){
		
		return repository.selectlesprix(id);
	}
	@Override
	public List<Long> selectlesqte(long id){
		
		return repository.selectlesqte(id);
	}

}
