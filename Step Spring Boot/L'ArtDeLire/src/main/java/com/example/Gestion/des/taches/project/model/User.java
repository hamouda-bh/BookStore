package com.example.Gestion.des.taches.project.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
    private String email;
    private String name;
    private String password;
    private boolean active;
    private String last_name;
    private String tel ;
    private String carte_paie ; 
    @ManyToOne //relation entre table 1..*
    private Role role ;
     
    @OneToMany( fetch = FetchType.EAGER ,  mappedBy = "user" , cascade = CascadeType.ALL)
	private List<Panier> panier;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCarte_paie() {
		return carte_paie;
	}
	public void setCarte_paie(String carte_paie) {
		this.carte_paie = carte_paie;
	}
	
	
	public List<Panier> getPanier() {
		return panier;
	}
	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}
	
    
    

}
