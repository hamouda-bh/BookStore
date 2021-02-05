package com.example.Gestion.des.taches.project.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
@Entity
public class Livre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private	 Long id ;
    private String name;
    private String description ;
    private String photo;
    private String author ;
    


	@Min(value=0,message="Price should be positive value")
	private float price;
	
	@Min(value = 0, message = "Total Count should be positive value.")
    private int totalCount;

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	@ManyToOne(cascade = CascadeType.REMOVE)  
    private Categorie categorie;
	public Long getId() {
		return id;
	}
	
	
	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public int getTotalCount() {
		return totalCount;
	}


}
