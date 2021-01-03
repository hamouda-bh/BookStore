package com.example.Gestion.des.taches.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Annonce {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String date_publication;
    private String date_achat;    
    private String prix;
    private String etat_de_livre;
    @ManyToMany
    private Livre livre;
    @ManyToOne
    private User user;
    
	public String getDate_publication() {
		return date_publication;
	}
	public void setDate_publication(String date_publication) {
		this.date_publication = date_publication;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
		this.prix = prix;
	}
	public String getEtat_de_livre() {
		return etat_de_livre;
	}
	public void setEtat_de_livre(String etat_de_livre) {
		this.etat_de_livre = etat_de_livre;
	}
	public String getDate_achat() {
		return date_achat;
	}
	public void setDate_achat(String date_achat) {
		this.date_achat = date_achat;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Livre getLivre() {
		return livre;
	}
	public void setLivre(Livre livre) {
		this.livre = livre;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
    
    

}
