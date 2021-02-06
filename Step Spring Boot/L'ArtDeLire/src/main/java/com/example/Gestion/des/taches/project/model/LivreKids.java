package com.example.Gestion.des.taches.project.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class LivreKids implements Serializable {
	
	@ManyToMany
	private List<CategorieKids> categorieKids;
	
	@Id
	private Long id;
	private String name;
	private String authorName;
    private String description;
	private String photo;
	
	@Temporal(TemporalType.DATE)
	private Date releaseDate;
    

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
	public List<CategorieKids> getCategorieKids() {
		return categorieKids;
	}
	public void setCategorieKids(List<CategorieKids> categorieKids) {
		this.categorieKids = categorieKids;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}