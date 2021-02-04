package com.example.Gestion.des.taches.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
//

public class CategorieKids implements Serializable {
	
	

	@ManyToMany(mappedBy="categorieKids")
	private List<LivreKids> livreKids;
	
	@Id
	private Long id ;
    private String name;
    private String description;
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
	public List<LivreKids> getLivreKids() {
		return livreKids;
	}
	public void setLivreKids(List<LivreKids> livreKids) {
		this.livreKids = livreKids;
	}
}
