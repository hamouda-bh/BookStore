package com.example.Gestion.des.taches.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Blog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_blog ;
	private int id_client ;
    private String categorie_blog;
    private String description;
    
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
	
		 public int getCategorie_blog() {
				return categorie_blog;
			}
			public void setcategorie_blog(int categorie_blog) {
				this.categorie_blog = categorie_blog;
			}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
