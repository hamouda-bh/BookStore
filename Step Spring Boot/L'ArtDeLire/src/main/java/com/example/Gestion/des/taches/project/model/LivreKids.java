package com.example.Gestion.des.taches.project.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class LivreKids {
	private Long id ;
    private String name;
    private String description;
    private String photo;
    
    @ManyToOne
    private CategorieKids categorieKids;
	public Long getId() {
		return id;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public CategorieKids getCategorieKids() {
		return categorieKids;
	}
	public void setCategorieKids(CategorieKids categorieKids) {
		this.categorieKids = categorieKids;
	}
}