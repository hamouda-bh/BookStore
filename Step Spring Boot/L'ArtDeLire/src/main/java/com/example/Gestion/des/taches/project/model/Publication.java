package com.example.Gestion.des.taches.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Publication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id_publication ;
	private int id_blog ;
	private int id_client ;
    private String contenue;
    private String commentaire;
    
    public int getId_publication() {
		return id_publication;
	}
	public void setId_publication(int id_publication) {
		this.id_publication = id_publication;
	}
    
    public int getId_blog() {
		return id_blog;
	}
	public void setId_blog(int id_blog) {
		this.id_blog = id_blog;
	}
	
	 public int getId_client() {
			return id_client;
		}
		public void setId_client(int id_client) {
			this.id_client = id_client;
		}
		
		public String getContenue() {
			return contenue;
		}
		
		
		public String getCommentaire() {
			return commentaire;
		}
		public void setContenue(String commentaire) {
			this.commentaire = commentaire;
		}
}
